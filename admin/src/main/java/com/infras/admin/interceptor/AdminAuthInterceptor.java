package com.infras.admin.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infras.admin.config.Constant;
import com.infras.admin.services.login.service.AdminLoginServices;
import com.infras.common.result.JsonResult;
import com.infras.common.tools.AuthUtil;
import com.infras.common.tools.Utils;
import com.infras.model.projos.AdminLogin;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

import static com.infras.common.error.ApiErrors.BASE_UNAUTHORIZED;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created by zhaoheng on 2017/9/19.
 */
@Slf4j
@Component
public class AdminAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AdminLoginServices adminLoginServices;

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        if(!_isValidRequest(request, response)){
            // GlobalController无法捕获Handler之前的异常, 所以要手动输出
            response.setStatus(SC_UNAUTHORIZED);
            response.setContentType(APPLICATION_JSON_UTF8_VALUE);
            response.setHeader(CACHE_CONTROL, "no-store");
            PrintWriter pw = response.getWriter();
            pw.print(objectMapper.writeValueAsString(JsonResult.error(BASE_UNAUTHORIZED)));
            pw.flush();
            return false;
        }
        return true;
    }

    private boolean _hasPermission(HttpServletRequest request) {
        String uri = request.getRequestURI();
        log.info(uri);
        return true;
    }

    private Optional<String> _getSession(HttpServletRequest request) {
        return Arrays.stream(request.getCookies()).filter(c -> Constant.SESSION_KEY.equals(c.getName())).findFirst().map(c -> c.getValue());
    }

    private boolean _isValidRequest(HttpServletRequest request, HttpServletResponse response) {
        // 1. 获取token、loginId token=yyMMddHH+加密串
        Optional<String> admin_session = _getSession(request);
        Object sessionLoginId = request.getSession().getAttribute("loginId");
        String token;
        Long loginId = -1L;

        if(sessionLoginId != null && Utils.isNumber(sessionLoginId.toString())){
            return true;
        }
        if(!admin_session.isPresent()) return false;
        String[] arr = admin_session.get().split("-");
        if(arr.length != 2) return false;
        token = arr[0];
        if(StringUtils.isNumeric(arr[1])) loginId = Long.parseLong(arr[1]);

        if(loginId < 1) return false;

        Optional<AdminLogin> login = adminLoginServices.getLoginByLoginId(loginId.intValue());
        if(!login.isPresent()) return false;

        _accessCheck(token, loginId.toString() + login.get().getPhone());

        _hasPermission(request);

        return true;
    }

    private boolean _accessCheck(String token, String row) {
        // token长度=loginTime
        if(token.length() != 50) return false;
        String strLoginTime = token.substring(0, 10);
        LocalDateTime loginTime = LocalDateTime.parse(strLoginTime, DateTimeFormatter.ofPattern("yyMMddHHmm"));
        String checkToken = _generateToken(loginTime, row);
        if(!token.equals(checkToken)) return false;
        return true;
    }

    private String _generateToken(LocalDateTime loginTime, String row) {
        // 登录时间
        String time = loginTime.format(DateTimeFormatter.ofPattern("yyMMddHHmm"));
        return time + AuthUtil.generateToken(row).get();
    }
}

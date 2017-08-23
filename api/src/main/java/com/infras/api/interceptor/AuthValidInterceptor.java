package com.infras.api.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infras.common.result.JsonResult;
import com.infras.common.tools.AuthUtil;
import com.infras.model.projos.Login;
import com.infras.services.login.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.infras.common.error.ApiErrors.BASE_UNAUTHORIZED;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@Component
public class AuthValidInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LoginService loginService;

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

    public boolean _isValidRequest(HttpServletRequest request, HttpServletResponse response) {
        // 1. 获取token、loginId token=yyMMddHH+加密串
        String token = request.getHeader("token");
        String strLoginId = request.getHeader("loginId");
        Object sessionLoginId = request.getSession().getAttribute("loginId").toString();
        Long loginId = -1L;

        if(StringUtil.isEmpty(token) || StringUtil.isEmpty(strLoginId)){
            if(sessionLoginId != null){
                loginId = Long.parseLong(sessionLoginId.toString());
            } else {
                return false;
            }
        } else {
            loginId = Long.parseLong(request.getHeader("loginId"));
        }

        if(loginId < 1) return false;

        Optional<Login> login = loginService.getLoginByLoginId(loginId.intValue());
        if(!login.isPresent()) return false;

        _accessCheck(token, loginId.toString() + login.get().getPhone());
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

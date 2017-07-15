package com.infras.api;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.CommonException;
import com.infras.common.error.ServiceException;
import com.infras.common.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.infras.common.error.ApiErrors.SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.*;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;

/**
 * Created by zhaoheng on 2017/7/13.
 */
@Slf4j
@ControllerAdvice
public class GlobalController {
    private static final String NO_STORE = "no-store";

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public JsonResult handleAllException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        return this._handleException(request, response, e);
    }
    /**
     * 处理异常的响应
     */
    private JsonResult _handleException(HttpServletRequest request, HttpServletResponse response, Throwable error) {
        response.setHeader(CACHE_CONTROL, NO_STORE);

        // 获取异常源
        while (error.getCause() != null) {
            if (error instanceof CommonException && !(error.getCause() instanceof CommonException)) {
                break;
            }
            error = error.getCause();
        }

        if(error instanceof ServiceException) {
            // 业务异常
            int code = ((ServiceException) error).getCode();
            String errorMsg = error.getMessage();
            if(code == ApiErrors.SERVER_ERROR.getCode()){
                log.error("ServiceException(SERVER_ERROR): " + errorMsg + ". [URL=" + request.getRequestURI() + "]", error);
                response.setStatus(SC_INTERNAL_SERVER_ERROR);
            } else {
                log.warn("ServiceException: " + errorMsg + ". [URL=" + request.getRequestURI() + "]", error);
                if (code == ApiErrors.REQUEST_PARAM_ERROR.getCode()) {
                    response.setStatus(SC_BAD_REQUEST);
                } else if (code == ApiErrors.RESOURCE_NOT_FIND_ERROR.getCode()) {
                    response.setStatus(SC_NOT_FOUND);
                } else if (code == ApiErrors.BASE_FORBIDDEN.getCode()) {
                    response.setStatus(SC_FORBIDDEN);
                }
            }
            return JsonResult.error(code, errorMsg);
        }else{
            // 其他异常都返回「服务器异常」错误
            log.error(error.getMessage());
            return JsonResult.error(SERVER_ERROR);
        }
    }
}

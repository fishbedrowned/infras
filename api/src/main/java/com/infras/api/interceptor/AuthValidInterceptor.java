package com.infras.api.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@Component
public class AuthValidInterceptor extends HandlerInterceptorAdapter {
    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String authorization = request.getHeader(AUTHORIZATION);
        System.out.print(authorization);

        return true;
    }

    public boolean isValidRequest(HttpServletRequest request) {
        // 1. 获取token、loginId
        String token = request.getHeader("token");
        String loginId = request.getHeader("loginId");

//        if()
        return true;
    }
}

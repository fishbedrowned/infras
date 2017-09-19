package com.infras.admin.config;

import com.infras.admin.interceptor.AdminAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private AdminAuthInterceptor adminAuthInterceptor;

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminAuthInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/", "/login", "/register", "/swagger-resources/**", "/v2/api-docs");
    }
}

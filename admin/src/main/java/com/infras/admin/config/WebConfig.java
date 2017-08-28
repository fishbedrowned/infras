package com.infras.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private AuthValidInterceptor authValidInterceptor;

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authValidInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register", "/phone/code");
//    }
}

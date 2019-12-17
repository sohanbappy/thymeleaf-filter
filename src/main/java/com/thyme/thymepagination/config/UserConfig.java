package com.thyme.thymepagination.config;

import com.thyme.thymepagination.interceptors.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserConfig implements WebMvcConfigurer {

    @Autowired
    UserInterceptor userIncptr;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userIncptr);
    }
}

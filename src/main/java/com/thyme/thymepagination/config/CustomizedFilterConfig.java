package com.thyme.thymepagination.config;

import com.thyme.thymepagination.filters.UserFilter;
import org.hibernate.internal.FilterConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizedFilterConfig {

    @Bean
    public FilterRegistrationBean<UserFilter> registrationBean(){
        FilterRegistrationBean<UserFilter> regBean = new FilterRegistrationBean<UserFilter>();
        regBean.setFilter(new UserFilter());
        regBean.addUrlPatterns("/user/add/*");
        return regBean;
    }

}

package com.thyme.thymepagination.config;

import com.thyme.thymepagination.filters.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizedFilterConfig {

    @Bean
    public FilterRegistrationBean<UserFilter> logFilter() {
        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/user/add/*");
        return registrationBean;
    }

}

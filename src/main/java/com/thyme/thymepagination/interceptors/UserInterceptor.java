package com.thyme.thymepagination.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String name = request.getParameter("name");
//        if(name.length()>10){
//            System.out.println("Name length is greater than 10 !!!!!!");
//            return false;
//        }
        System.out.println("PreHandle Method is Called!!!!!");
        return super.preHandle(request,response,handler);
    }
}

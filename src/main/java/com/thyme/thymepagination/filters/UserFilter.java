package com.thyme.thymepagination.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1) //ordering is needed when multiple filters are applied
public class UserFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("User filter is working From........"+req.getMethod()+" "+req.getRequestURI()+" and Name is: "+name);
        chain.doFilter(req,res);
    }
}

package com.example.Java4_Buoi2.javawebb2.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter({"/sinh-vien/*"})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("Khi init");
    }

    public void destroy() {
        Filter.super.destroy();
        System.out.println("Khi destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("Do filter before");
         chain.doFilter(request, response);
    }
}

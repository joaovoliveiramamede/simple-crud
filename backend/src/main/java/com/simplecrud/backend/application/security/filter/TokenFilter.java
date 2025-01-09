package com.simplecrud.backend.application.security.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class TokenFilter implements Filter {

    private static final String BEARER_PREFIX = "Bearer ";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServlet) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            chain.doFilter(request,response);
        }
        chain.doFilter(request,response);
    }


}

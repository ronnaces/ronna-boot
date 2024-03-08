package com.ronnaces.ronna.boot.system.component.api.filter;

import com.ronnaces.ronna.boot.system.component.api.wapper.SignatureRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class SignatureFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = new SignatureRequestWrapper((HttpServletRequest) request);
        chain.doFilter(requestWrapper, response);
    }
}


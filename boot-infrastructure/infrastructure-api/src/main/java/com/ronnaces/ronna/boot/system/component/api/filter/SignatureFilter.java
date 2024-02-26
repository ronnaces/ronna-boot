package com.ronnaces.ronna.boot.system.component.api.filter;

import com.ronnaces.ronna.boot.system.component.api.wapper.SignatureRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * SignatureFilter
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/3 14:13
 */
@Slf4j
public class SignatureFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = new SignatureRequestWrapper((HttpServletRequest) request);
        chain.doFilter(requestWrapper, response);
    }
}


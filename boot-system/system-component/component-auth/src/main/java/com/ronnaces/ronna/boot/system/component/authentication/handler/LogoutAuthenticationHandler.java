package com.ronnaces.ronna.boot.system.component.authentication.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

/**
 * LogoutAuthenticationHandler
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/10 5:26
 */
@Component
public class LogoutAuthenticationHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        SecurityContextHolder.clearContext();
    }
}
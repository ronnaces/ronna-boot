package com.ronnaces.ronna.boot.system.component.auth.handler;//package com.preciser.boot.system.component.handler;
//
//import com.alibaba.fastjson2.JSON;
//import com.ronnaces.ronna.common.controller.R;//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//
//@Component
//public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
//        R<?> result;
//        if (exception instanceof UsernameNotFoundException usernameNotFoundException) {
//            result = R.fail(HttpServletResponse.SC_UNAUTHORIZED, usernameNotFoundException.getMessage());
//        } else if (exception instanceof BadCredentialsException badCredentialsException) {
//            result = R.fail(HttpServletResponse.SC_UNAUTHORIZED, badCredentialsException.getMessage());
//        } else {
//            result = R.fail(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
//        }
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//        response.getWriter().println(JSON.toJSON(result));
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.flushBuffer();
//    }
//}
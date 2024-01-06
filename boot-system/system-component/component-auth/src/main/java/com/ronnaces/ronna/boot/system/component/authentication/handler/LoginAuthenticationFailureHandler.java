//package com.ronnaces.boot.system.component.handler;
//
//import com.alibaba.fastjson.JSON;
//import com.ronnaces.loong.common.controller.Result;//import jakarta.servlet.http.HttpServletRequest;
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
///**
// * LoginAuthenticationFailureHandler
// *
// * @author KunLong-Luo
// * @version 1.0.0
// * @since 2023/3/10 5:26
// */
//@Component
//public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
//        Result<?> result;
//        if (exception instanceof UsernameNotFoundException usernameNotFoundException) {
//            result = Result.fail(HttpServletResponse.SC_UNAUTHORIZED, usernameNotFoundException.getMessage());
//        } else if (exception instanceof BadCredentialsException badCredentialsException) {
//            result = Result.fail(HttpServletResponse.SC_UNAUTHORIZED, badCredentialsException.getMessage());
//        } else {
//            result = Result.fail(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
//        }
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//        response.getWriter().println(JSON.toJSON(result));
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.flushBuffer();
//    }
//}
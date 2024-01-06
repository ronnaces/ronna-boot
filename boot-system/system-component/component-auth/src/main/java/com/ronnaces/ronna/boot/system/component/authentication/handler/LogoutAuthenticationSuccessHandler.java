package com.ronnaces.ronna.boot.system.component.authentication.handler;

import com.alibaba.fastjson.JSON;
import com.ronnaces.loong.common.controller.Result;import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * LogoutAuthenticationSuccessHandler
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/10 5:26
 */
@Component
public class LogoutAuthenticationSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().println(JSON.toJSON(Result.success("注销成功")));
        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
    }
}
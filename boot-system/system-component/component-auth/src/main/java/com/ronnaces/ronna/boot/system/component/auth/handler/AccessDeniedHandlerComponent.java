package com.ronnaces.ronna.boot.system.component.auth.handler;

import com.alibaba.fastjson.JSON;
import com.ronnaces.loong.common.controller.Result;import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * LoginAccessDeniedHandler
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/10 5:26
 */
@Slf4j
@Component
public class AccessDeniedHandlerComponent implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            log.warn("User: " + authentication.getName()
                    + " attempted to access the protected URL: "
                    + request.getRequestURI());
        }

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().println(JSON.toJSON(Result.fail(HttpServletResponse.SC_FORBIDDEN, "无权访问")));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.flushBuffer();
    }

}

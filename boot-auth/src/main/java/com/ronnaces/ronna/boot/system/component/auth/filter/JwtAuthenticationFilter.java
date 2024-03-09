package com.ronnaces.ronna.boot.system.component.auth.filter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.ronnaces.loong.core.constant.CommonConstant;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.contanst.AuthConstant;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthProperties authProperties;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AuthConstant.HEADER_AUTHORIZATION);
        if (StringUtils.isEmpty(token) || nonBearer(token) || hasWhiteUrl(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = getAccessToken(token);
        Object userClaim = JJWTUtil.getClaim(accessToken, "user");
        WebUser user = JSON.parseObject(JSON.toJSONString(userClaim), WebUser.class, JSONReader.Feature.SupportArrayToBean);

        if (Objects.nonNull(user) && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (JJWTUtil.nonExpired(accessToken)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean hasWhiteUrl(String requestUrl) {
        return Arrays.stream(authProperties.getPermits()).anyMatch(url -> StringUtils.startsWith(requestUrl, url));
    }

    private boolean hasBearer(String authorization) {
        return StringUtils.startsWith(authorization, AuthConstant.HEADER_AUTHORIZATION_BEARER);
    }

    private boolean nonBearer(String authorization) {
        return !hasBearer(authorization);
    }

    private String getAccessToken(String authorization) {
        return authorization.split(CommonConstant.SPACE)[1].trim();
    }

}

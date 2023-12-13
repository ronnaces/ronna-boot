package com.ronnaces.ronna.boot.system.component.authentication.filter;

import com.ronnaces.ronna.boot.system.component.authentication.config.AuthenticationProperties;
import com.ronnaces.ronna.boot.system.component.authentication.config.SecurityConfiguration;
import com.ronnaces.ronna.boot.system.component.authentication.contanst.AuthenticationConstant;
import com.ronnaces.loong.core.constant.CommonConstant;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JwtAuthenticationFilter
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/4/1 12:42
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;

    private final AuthenticationProperties authenticationProperties;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AuthenticationConstant.HEADER_AUTHORIZATION);
        if (StringUtils.isEmpty(token) || nonBearer(token) || hasWhiteUrl(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = getAccessToken(token);
        String subject = JJWTUtil.getSubject(accessToken);
        String audience = JJWTUtil.getAudience(accessToken);

        if (StringUtils.isNotEmpty(subject) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = userDetailsService.loadUserByUsername(subject);
            if (JJWTUtil.nonExpired(accessToken)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(subject, null, user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean hasWhiteUrl(String requestUrl) {
        return CollectionUtils.union(authenticationProperties.getPermits(), SecurityConfiguration.WHITE_LIST_URL).contains(requestUrl);
    }

    private boolean hasBearer(String authorization) {
        return StringUtils.startsWith(authorization, AuthenticationConstant.HEADER_AUTHORIZATION_BEARER);
    }

    private boolean nonBearer(String authorization) {
        return !hasBearer(authorization);
    }

    private String getAccessToken(String authorization) {
        return authorization.split(CommonConstant.SPACE)[1].trim();
    }

}

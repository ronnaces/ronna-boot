package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.alibaba.fastjson2.JSON;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.LoginResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.RefreshTokenResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.contanst.AuthResponseStatusCodes;
import com.ronnaces.ronna.boot.system.component.auth.event.UserRegistrationEvent;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.component.auth.service.IAuthService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


@AllArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private final ISystemRoleService roleService;

    private final ISystemUserService userService;

    private final PasswordEncoder encoder;

    private final ApplicationEventPublisher eventPublisher;

    private final AuthProperties authProperties;

    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest entity, HttpServletRequest request) {
        return login(auth(entity.getUsername(), entity.getPassword()), request);
    }

    @Override
    public WebUser auth(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return (WebUser) authenticate.getPrincipal();
    }


    private LoginResponse login(WebUser auth, HttpServletRequest request) {
        UserResponse userResponse = new UserResponse();
        userResponse.setRoles(userResponse.toRole(auth.getAuthorities()));
        userResponse.setPermissions(auth.getPermissionList());
        userResponse.setUserId(auth.getId());
        userResponse.setUsername(auth.getUsername());
        userResponse.setName(auth.getUsername());
        userResponse.setAvatar(auth.getAvatar());

        Map<String, Object> claim = new HashMap<>();
        claim.put("user", JSON.toJSON(auth));
        String accessToken = JJWTUtil.generate(request.getRemoteHost(), userResponse.getUsername(), authProperties.getAccessTokenExpire(), claim);
        String refreshToken = JJWTUtil.generate(request.getRemoteHost(), userResponse.getUsername(), authProperties.getRefreshTokenExpire(), claim);

        LoginResponse response = new LoginResponse();
        response.setUser(userResponse);
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        return response;
    }

    private void verifySmsCode(String smsCode) {
        if (StringUtils.isEmpty(smsCode)) {
            throw new LoongException(AuthResponseStatusCodes.SMS_CODE_IS_NULL);
        }

        // TODO 线上环境替换正式校验算法
        if (!StringUtils.equals("888888", smsCode)) {
            throw new LoongException(AuthResponseStatusCodes.SMS_CODE_VERIFY_FAILURE);
        }
    }

    @Override
    public void register(RegisterRequest entity) {
        SystemUser user = Optional.ofNullable(userService.find(entity.getUsername())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        if (Objects.nonNull(user)) {
            throw new LoongException(AuthResponseStatusCodes.USER_ALREADY_EXISTS);
        }
        verifySmsCode(entity.getSmsCode());
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(entity.getUsername());
        systemUser.setPhone(entity.getPhone());
        systemUser.setPassword(encoder.encode(entity.getPassword()));
        userService.save(systemUser);
        eventPublisher.publishEvent(new UserRegistrationEvent(entity));
    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshToken) {
        String username = JJWTUtil.getSubject(refreshToken);
        SystemUser user = Optional.ofNullable(userService.find(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
//        String tenant;
//        try {
//            tenant = Optional.ofNullable(tenantMapper.findCodeByUsername(username)).orElseThrow(() -> new AccessDeniedException("当前租户不存在"));
//        } catch (AccessDeniedException e) {
//            throw new RuntimeException(e);
//        }

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);

        Map<String, Object> claim = new HashMap<>();
        claim.put("userinfo", JSON.toJSON(userResponse));

        Set<String> roleList = roleService.findCodeByUserId(user.getId());
        userResponse.setRoles(roleList);

        long expire = 2 * 60 * 60 * 1000L;
        String accessToken = JJWTUtil.generate("", username, expire, claim);

        RefreshTokenResponse token = new RefreshTokenResponse();
        token.setExpires(LocalDateTime.now().plus(expire, ChronoUnit.MILLIS));
        token.setAccessToken(accessToken);
        token.setRefreshToken(accessToken);
        return token;
    }
}


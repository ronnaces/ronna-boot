package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.service.IAuthService;
import com.ronnaces.ronna.boot.system.component.auth.service.IPasswordService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class PasswordServiceImpl implements IPasswordService {

    private final ISystemUserService userService;

    private final IAuthService authService;

    private final PasswordEncoder encoder;

    private final AuthProperties authProperties;

    @Override
    public void changePassword(ChangePasswordRequest entity) {
        SystemUser user = Optional.ofNullable(userService.find(entity.getUsername())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        if (!encoder.matches(entity.getOldPassword(), user.getPassword())) {
            throw new UsernameNotFoundException("输入的用户名或密码不正确");
        }

        user.setPassword(encoder.encode(entity.getPassword()));
        userService.updateById(user);
        authService.auth(entity.getUsername(), entity.getPassword());
    }

    @Override
    public void resetPassword(String userId) {
        SystemUser user = Optional.ofNullable(userService.getById(userId)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        String defaultPassword = authProperties.getDefaultPassword();
        user.setPassword(encoder.encode(defaultPassword));
        userService.updateById(user);
    }

}


package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.ProfileRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.service.IProfileService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class ProfileServiceImpl implements IProfileService {

    private final ISystemUserService userService;

    private final PasswordEncoder encoder;

    private final AuthProperties authProperties;

    @Override
    public void edit(String name, ProfileRequest request) {
        SystemUser user = Optional.ofNullable(userService.find(name)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        BeanUtils.copyProperties(request, user);
        userService.updateById(user);
    }

    @Override
    public UserResponse detail(String name) {
        return null;
    }

    @Override
    public void resetPassword(String name) {
        SystemUser user = Optional.ofNullable(userService.find(name)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        String defaultPassword = authProperties.getDefaultPassword();
        user.setPassword(encoder.encode(defaultPassword));
        userService.updateById(user);
    }
}


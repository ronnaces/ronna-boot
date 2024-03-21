package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.service.IUserService;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@AllArgsConstructor
@Service
public class AuthUserServiceImpl implements IUserService {

    private final ISystemRoleService roleService;

    private final ISystemUserService userService;

    @Override
    public UserResponse info(String username) {
        SystemUser user = Optional.ofNullable(userService.find(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        UserResponse userResponse = UserResponse.of(user);

        Set<String> roleList = roleService.findCodeByUserId(user.getId());
        if (CollectionUtils.isNotEmpty(roleList)) {
            userResponse.setRoles(roleList);
        }
        return userResponse;
    }

}


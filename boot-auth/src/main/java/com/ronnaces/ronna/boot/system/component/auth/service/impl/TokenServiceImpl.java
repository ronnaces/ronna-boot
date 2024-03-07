package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Component
public class TokenServiceImpl {

    private final ISystemUserService userService;

    private final ISystemDepartmentService departmentService;

    private final ISystemRoleService roleService;

    private final ISystemPermissionService permissionService;

    private final AuthProperties authProperties;

    public void refreshToken(WebUser user) {
        Map<String, Object> claim = new HashMap<>();
        claim.put("user", JSON.toJSON(user));
        String accessToken = JJWTUtil.generate("web", user.getUsername(), authProperties.getAccessTokenExpire(), claim);
    }
}

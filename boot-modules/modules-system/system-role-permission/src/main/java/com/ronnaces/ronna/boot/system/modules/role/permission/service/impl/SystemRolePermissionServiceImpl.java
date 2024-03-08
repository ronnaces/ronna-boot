package com.ronnaces.ronna.boot.system.modules.role.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.modules.role.permission.mapper.SystemRolePermissionMapper;
import com.ronnaces.ronna.boot.system.modules.role.permission.service.ISystemRolePermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SystemRolePermissionServiceImpl extends ServiceImpl<SystemRolePermissionMapper, SystemRolePermission> implements ISystemRolePermissionService {

    private final SystemRolePermissionMapper mapper;

}


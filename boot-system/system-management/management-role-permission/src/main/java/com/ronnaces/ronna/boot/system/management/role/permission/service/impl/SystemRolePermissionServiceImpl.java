package com.ronnaces.ronna.boot.system.management.role.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.management.role.permission.mapper.SystemRolePermissionMapper;
import com.ronnaces.ronna.boot.system.management.role.permission.service.ISystemRolePermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemRolePermissionServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-28
 */
@AllArgsConstructor
@Service
public class SystemRolePermissionServiceImpl extends ServiceImpl<SystemRolePermissionMapper, SystemRolePermission> implements ISystemRolePermissionService {

    private final SystemRolePermissionMapper mapper;

}


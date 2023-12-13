package com.ronnaces.ronna.boot.system.management.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.management.role.mapper.SystemRoleMapper;
import com.ronnaces.ronna.boot.system.management.role.service.ISystemRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SystemRoleServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@AllArgsConstructor
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {

    private final SystemRoleMapper mapper;

    @Override
    public List<String> permission(String id) {
        return mapper.findAllPermissionIdById(id);
    }
}


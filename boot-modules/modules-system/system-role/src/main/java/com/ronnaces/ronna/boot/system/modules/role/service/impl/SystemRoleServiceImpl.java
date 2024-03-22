package com.ronnaces.ronna.boot.system.modules.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.mapper.SystemRoleMapper;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {

    private final SystemRoleMapper mapper;

    @Override
    public List<String> permission(String id) {
        return mapper.findAllPermissionIdById(id);
    }

    @Override
    public Set<String> findCodeByUserId(String userId) {
        return mapper.findCodeByUserId(userId);
    }

    @Override
    public List<SystemRole> findOfUserId(String id) {
        return mapper.findByUserId(id);
    }

    @Override
    public List<String> findByPermissionId(String id) {
        return mapper.findByPermissionId(id);
    }

    @Override
    public SystemRole find(String code) {
        return mapper.findByCode(code);
    }

    @Override
    public List<String> menuId(String id) {
        return mapper.findAllPermissionIdById(id);
    }
}


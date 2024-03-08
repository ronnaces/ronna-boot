package com.ronnaces.ronna.boot.system.modules.user.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.modules.user.role.mapper.SystemUserRoleMapper;
import com.ronnaces.ronna.boot.system.modules.user.role.service.ISystemUserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SystemUserRoleServiceImpl extends ServiceImpl<SystemUserRoleMapper, SystemUserRole> implements ISystemUserRoleService {

    private final SystemUserRoleMapper mapper;

}


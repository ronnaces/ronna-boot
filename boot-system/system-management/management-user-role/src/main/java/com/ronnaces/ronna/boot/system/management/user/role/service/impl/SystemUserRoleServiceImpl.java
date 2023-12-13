package com.ronnaces.ronna.boot.system.management.user.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.management.user.role.mapper.SystemUserRoleMapper;
import com.ronnaces.ronna.boot.system.management.user.role.service.ISystemUserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemUserRoleServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-27
 */
@AllArgsConstructor
@Service
public class SystemUserRoleServiceImpl extends ServiceImpl<SystemUserRoleMapper, SystemUserRole> implements ISystemUserRoleService {

    private final SystemUserRoleMapper mapper;

}


package com.ronnaces.ronna.boot.system.modules.role.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.role.permission.entity.SystemRolePermission;

import java.util.List;


public interface ISystemRolePermissionService extends IService<SystemRolePermission> {

    List<String> findOfRoleId(String roleId);
}

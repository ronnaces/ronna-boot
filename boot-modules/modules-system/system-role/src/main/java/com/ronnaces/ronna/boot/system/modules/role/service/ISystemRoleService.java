package com.ronnaces.ronna.boot.system.modules.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;

import java.util.List;

/**
 * ISystemRoleService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
public interface ISystemRoleService extends IService<SystemRole> {

    List<String> permission(String id);
}

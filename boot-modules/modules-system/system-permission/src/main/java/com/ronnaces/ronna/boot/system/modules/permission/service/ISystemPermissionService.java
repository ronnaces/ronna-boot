package com.ronnaces.ronna.boot.system.modules.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * ISystemPermissionService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
public interface ISystemPermissionService extends IService<SystemPermission> {

    List<SystemPermission> tree(List<SystemPermission> permissionList);

    Set<String> findCodeByUserId(String userId);

}

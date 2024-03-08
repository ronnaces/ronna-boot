package com.ronnaces.ronna.boot.system.modules.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface ISystemPermissionService extends IService<SystemPermission> {

    List<SystemPermission> tree(List<SystemPermission> permissionList);

    List<SystemPermission> findOfRoleId(String roleId);

    Set<String> findCodeByUserId(String userId);

    List<SystemPermission> userPermission(String userId);

}

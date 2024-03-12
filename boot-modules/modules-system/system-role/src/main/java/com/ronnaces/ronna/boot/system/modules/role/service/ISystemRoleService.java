package com.ronnaces.ronna.boot.system.modules.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.request.AdjustStateRequest;

import java.util.List;
import java.util.Set;


public interface ISystemRoleService extends IService<SystemRole> {

    List<String> permission(String id);

    List<SystemRole> findOfUserId(String id);

    Set<String> findCodeByUserId(String userId);

    void adjustState(AdjustStateRequest request);

    List<String> findByPermissionId(String id);
}

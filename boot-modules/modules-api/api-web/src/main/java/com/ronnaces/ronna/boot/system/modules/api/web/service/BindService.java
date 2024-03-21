package com.ronnaces.ronna.boot.system.modules.api.web.service;

import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;
import com.ronnaces.ronna.boot.system.modules.department.user.service.ISystemDepartmentUserService;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.modules.role.permission.service.ISystemRolePermissionService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.modules.user.role.service.ISystemUserRoleService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class BindService {

    private final ISystemRolePermissionService rolePermissionService;

    private final ISystemDepartmentUserService departmentUserService;

    private final ISystemUserRoleService userRoleService;

    private final ISystemRoleService roleService;

    private final ISystemPermissionService permissionService;

    private final ISystemDepartmentService departmentService;

    public void bindRole(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = userRoleService.findOfUserId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            userRoleService.removeBatchByIds(relationshipId);
        }
        List<SystemRole> daoList = roleService.listByIds(minorIds);
        if (CollectionUtils.isEmpty(daoList)) {
            return;
        }
        List<SystemUserRole> saveList = new ArrayList<>();
        daoList.stream().distinct().forEach(dao -> {
            SystemUserRole entity = new SystemUserRole();
            entity.setUserId(mainId);
            entity.setRoleId(dao.getId());
            saveList.add(entity);
        });
        userRoleService.saveBatch(saveList);
    }

    public void bindPermission(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = rolePermissionService.findOfRoleId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            rolePermissionService.removeBatchByIds(relationshipId);
        }
        List<SystemPermission> daoList = permissionService.listByIds(minorIds);
        if (CollectionUtils.isEmpty(daoList)) {
            return;
        }
        List<SystemRolePermission> saveList = new ArrayList<>();
        daoList.stream().distinct().forEach(dao -> {
            SystemRolePermission entity = new SystemRolePermission();
            entity.setRoleId(mainId);
            entity.setPermissionId(dao.getId());
            saveList.add(entity);
        });
        rolePermissionService.saveBatch(saveList);
    }

    public void bindDepartment(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = departmentUserService.findOfUserId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            departmentUserService.removeBatchByIds(relationshipId);
        }
        List<SystemDepartment> daoList = departmentService.listByIds(minorIds);
        if (CollectionUtils.isEmpty(daoList)) {
            return;
        }
        List<SystemDepartmentUser> saveList = new ArrayList<>();
        daoList.stream().distinct().forEach(dao -> {
            SystemDepartmentUser entity = new SystemDepartmentUser();
            entity.setUserId(mainId);
            entity.setDepartmentId(dao.getId());
            saveList.add(entity);
        });
        departmentUserService.saveBatch(saveList);
    }

    public void unbindRole(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = userRoleService.findOfUserId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            userRoleService.removeBatchByIds(relationshipId);
        }
    }

    public void unbindPermission(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = rolePermissionService.findOfRoleId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            rolePermissionService.removeBatchByIds(relationshipId);
        }
    }

    public void unbindDepartment(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = departmentUserService.findOfUserId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            departmentUserService.removeBatchByIds(relationshipId);
        }
    }
}


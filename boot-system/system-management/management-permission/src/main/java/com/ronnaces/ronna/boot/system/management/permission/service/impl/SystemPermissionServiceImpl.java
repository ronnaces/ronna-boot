package com.ronnaces.ronna.boot.system.management.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.loong.core.structure.tree.TreeUtils;
import com.ronnaces.ronna.boot.system.management.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.management.permission.mapper.SystemPermissionMapper;
import com.ronnaces.ronna.boot.system.management.permission.service.ISystemPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SystemPermissionServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@AllArgsConstructor
@Service
public class SystemPermissionServiceImpl extends ServiceImpl<SystemPermissionMapper, SystemPermission> implements ISystemPermissionService {

    @Override
    public List<SystemPermission> tree(List<SystemPermission> permissionList) {
        return TreeUtils.buildTree(permissionList);
    }

}


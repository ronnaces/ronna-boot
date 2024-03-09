package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ronnaces.loong.core.structure.tree.TreeUtils;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.Department;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.service.IUserService;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final ISystemRoleService roleService;

    private final ISystemUserService userService;

    private final ISystemDepartmentService departmentService;

    @Override
    public UserResponse info(String username) {
        SystemUser user = Optional.ofNullable(userService.find(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        UserResponse userResponse = UserResponse.of(user);

        Set<String> roleList = roleService.findCodeByUserId(user.getId());
        if (CollectionUtils.isNotEmpty(roleList)) {
            userResponse.setRoles(roleList);
        }
        return userResponse;
    }

    @Override
    public Boolean unique(SystemUser entity) {
        SystemUser user = userService.getOne(new QueryWrapper<>(entity));
        if (Objects.isNull(user)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<Department> userDepartment() {
        List<SystemDepartment> departmentList = departmentService.list();
        if (CollectionUtils.isEmpty(departmentList)) {
            return Collections.singletonList(new Department());
        }

        List<Department> routerList = new ArrayList<>();
        departmentList.forEach(item -> {
            Department department = new Department();
            BeanUtils.copyProperties(item, department);
            routerList.add(department);
        });
        return TreeUtils.buildTree(routerList);
    }

    @Override
    public Boolean exist(String username) {
        return Objects.nonNull(userService.find(username));
    }

}


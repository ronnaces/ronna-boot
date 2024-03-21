package com.ronnaces.ronna.boot.system.modules.api.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ronnaces.loong.common.controller.CommonService;
import com.ronnaces.loong.common.entity.PageEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.role.CreateRoleRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.role.EditRoleRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role.RoleMenuResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role.RoleResponse;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@Service
public class RoleService implements CommonService<SystemRole> {

    private final ISystemRoleService service;

    private final ISystemPermissionService permissionService;

    public boolean create(CreateRoleRequest payload) {
        return service.save(CreateRoleRequest.to(payload));
    }

    public boolean edit(EditRoleRequest payload) {
        return service.updateById(EditRoleRequest.to(payload, service.getById(payload.getId())));
    }

    public void editState(EditStateRequest request) {
        SystemRole entity = Optional.ofNullable(service.getById(request.getId())).orElseThrow(() -> new LoongException("当前用户不存在"));
        entity.setState(request.getStatus());
        service.updateById(entity);
    }

    public PageResult<RoleResponse> page(PageEntity entity) {
        PageResult<SystemRole> pageResult = of(service.page(new Page<>(entity.getPage(), entity.getPageSize()), createQueryWrapper(entity)));
        List<RoleResponse> responses = pageResult.getRecords().stream().map(RoleResponse::of).collect(Collectors.toList());
        PageResult<RoleResponse> result = new PageResult<>();
        result.setTotal(pageResult.getTotal());
        result.setCurrent(pageResult.getCurrent());
        result.setSize(pageResult.getSize());
        result.setRecords(responses);
        return result;
    }

    public List<RoleMenuResponse> menu() {
        return permissionService.list().stream().map(RoleMenuResponse::of).collect(Collectors.toList());
    }

    public List<String> menuId(String id) {
        return service.menuId(id);
    }
}


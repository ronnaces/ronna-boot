package com.ronnaces.ronna.boot.system.modules.api.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ronnaces.loong.common.controller.CommonService;
import com.ronnaces.loong.common.entity.PageEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.menu.CreateMenuRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.menu.EditMenuRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.menu.MenuResponse;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@Service
public class MenuService implements CommonService<SystemPermission> {

    private final ISystemPermissionService service;

    public boolean create(CreateMenuRequest payload) {
        return service.save(CreateMenuRequest.to(payload));
    }

    public boolean edit(EditMenuRequest payload) {
        return service.updateById(EditMenuRequest.to(payload, service.getById(payload.getId())));
    }

    public void editState(EditStateRequest request) {
        SystemPermission entity = Optional.ofNullable(service.getById(request.getId())).orElseThrow(() -> new LoongException("当前用户不存在"));
        service.updateById(entity);
    }

    public PageResult<MenuResponse> page(PageEntity entity) {
        PageResult<SystemPermission> pageResult = of(service.page(new Page<>(entity.getPage(), entity.getPageSize()), createQueryWrapper(entity)));
        List<MenuResponse> responses = to(pageResult.getRecords());
        PageResult<MenuResponse> result = new PageResult<>();
        result.setTotal(pageResult.getTotal());
        result.setCurrent(pageResult.getCurrent());
        result.setSize(pageResult.getSize());
        result.setRecords(responses);
        return result;
    }

    private List<MenuResponse> to(List<SystemPermission> records) {
        return records.stream().map(this::from).collect(Collectors.toList());
    }

    private MenuResponse from(SystemPermission user) {
        MenuResponse response = new MenuResponse();
        BeanUtils.copyProperties(user, response);
        response.setRemark(user.getDescription());
        return response;
    }
}


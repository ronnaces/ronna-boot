package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.R;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.BindRequest;
import com.ronnaces.ronna.boot.system.component.auth.service.IBindService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Tag(name = "绑定管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/bind")
public class BindController {

    private final IBindService service;

    @Operation(summary = "绑定角色")
    @PostMapping(value = "/role")
    public R<?> bindRole(@RequestBody BindRequest request) {
        service.bindRole(request.getMainId(), request.getMinorIds());
        return R.ok();
    }

    @Operation(summary = "绑定权限")
    @PostMapping(value = "/permission")
    public R<?> bindPermission(@RequestBody BindRequest request) {
        service.bindPermission(request.getMainId(), request.getMinorIds());
        return R.ok();
    }

    @Operation(summary = "绑定部门")
    @PostMapping(value = "/department")
    public R<?> bindDepartment(@RequestBody BindRequest request) {
        service.bindDepartment(request.getMainId(), request.getMinorIds());
        return R.ok();
    }

    @Operation(summary = "解绑角色")
    @DeleteMapping(value = "/role")
    public R<?> unbindRole(@RequestBody BindRequest request) {
        service.unbindRole(request.getMainId(), request.getMinorIds());
        return R.ok();
    }

    @Operation(summary = "解绑权限")
    @DeleteMapping(value = "/permission")
    public R<?> unbindPermission(@RequestBody BindRequest request) {
        service.unbindPermission(request.getMainId(), request.getMinorIds());
        return R.ok();
    }

    @Operation(summary = "解绑部门")
    @DeleteMapping(value = "/department")
    public R<?> unbindDepartment(@RequestBody BindRequest request) {
        service.unbindDepartment(request.getMainId(), request.getMinorIds());
        return R.ok();
    }
}

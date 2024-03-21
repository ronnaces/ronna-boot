package com.ronnaces.ronna.boot.system.modules.api.web.controller;

import com.ronnaces.loong.common.entity.PageEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.loong.core.annotation.EditLogger;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.role.CreateRoleRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.role.EditRoleRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role.RoleMenuResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role.RoleResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "角色API")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/role")
public class RoleController {

    private final RoleService service;

    @Operation(summary = "创建")
    @EditLogger("创建")
    @PostMapping("/create")
    public R<Boolean> create(@RequestBody CreateRoleRequest payload) {
        return R.ok(service.create(payload));
    }

    @Operation(summary = "编辑")
    @EditLogger("编辑")
    @PostMapping("/edit")
    public R<Boolean> edit(@RequestBody EditRoleRequest payload) {
        return R.ok(service.edit(payload));
    }


    @Operation(summary = "调整状态")
    @PutMapping(value = "/edit/state")
    public R<?> editState(@RequestBody EditStateRequest request) {
        service.editState(request);
        return R.ok();
    }

    @Operation(summary = "分页列表")
    @PostMapping("/page")
    public R<PageResult<RoleResponse>> page(@RequestBody PageEntity entity) {
        return R.ok(service.page(entity));
    }

    @Operation(summary = "角色菜单")
    @GetMapping("/menu")
    public R<List<RoleMenuResponse>> menu() {
        return R.ok(service.menu());
    }

    @Operation(summary = "角色菜单编号")
    @GetMapping({"/menu/{id:.+}"})
    public R<List<String>> menuId(@PathVariable(name = "id") String id) {
        return R.ok(service.menuId(id));
    }
}
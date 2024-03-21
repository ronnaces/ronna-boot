package com.ronnaces.ronna.boot.system.modules.api.web.controller;

import com.ronnaces.loong.common.entity.PageEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.loong.core.annotation.EditLogger;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.menu.CreateMenuRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.menu.EditMenuRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.menu.MenuResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "菜单API")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/menu")
public class MenuController {

    private final MenuService service;

    @Operation(summary = "创建")
    @EditLogger("创建")
    @PostMapping("/create")
    public R<Boolean> create(@RequestBody CreateMenuRequest payload) {
        return R.ok(service.create(payload));
    }

    @Operation(summary = "编辑")
    @EditLogger("编辑")
    @PostMapping("/edit")
    public R<Boolean> edit(@RequestBody EditMenuRequest payload) {
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
    public R<PageResult<MenuResponse>> page(@RequestBody PageEntity entity) {
        return R.ok(service.page(entity));
    }

}
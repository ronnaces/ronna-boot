package com.ronnaces.ronna.boot.system.modules.permission.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.entity.ListEntity;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "权限表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/permission")
public class SystemPermissionController implements CrudExcelController<SystemPermission> {

    private final ISystemPermissionService service;

    @Operation(summary = "查询权限树")
    @PostMapping(value = "/tree")
    public R<List<SystemPermission>> tree(SystemPermission payload, @RequestBody ListEntity entity) {
        return R.ok(service.tree(this.getService().list(this.createQueryWrapper(payload, entity))));
    }

}
package com.ronnaces.ronna.boot.system.modules.permission.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.common.entity.ListEntity;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SystemPermissionController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Tag(name = "权限表")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/system/permission")
public class SystemPermissionController implements CrudExcelController<SystemPermission> {

    private final ISystemPermissionService service;

    /**
     * tree
     *
     * @return {@link Result}<{@link SystemPermission}>
     */
    @Operation(summary = "查询权限树")
    @PostMapping(value = "/tree")
    public Result<List<SystemPermission>> tree(SystemPermission payload, @RequestBody ListEntity entity) {
        return Result.success(service.tree(this.getService().list(this.createQueryWrapper(payload, entity))));
    }

}
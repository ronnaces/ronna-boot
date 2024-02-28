package com.ronnaces.ronna.boot.system.modules.role.permission.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.modules.role.permission.service.ISystemRolePermissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemRolePermissionController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-28
 */
@Tag(name = "角色权限表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/role/permission")
public class SystemRolePermissionController implements CrudExcelController<SystemRolePermission> {

    private final ISystemRolePermissionService service;

}
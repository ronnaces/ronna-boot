package com.ronnaces.ronna.boot.system.management.role.permission.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.management.role.permission.service.ISystemRolePermissionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/role/permission")
public class SystemRolePermissionController implements CrudExcelController<SystemRolePermission> {

    @Getter
    private final ISystemRolePermissionService service;

}
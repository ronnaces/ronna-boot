package com.ronnaces.ronna.boot.system.management.user.role.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.management.user.role.service.ISystemUserRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemUserRoleController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-27
 */
@Tag(name = "用户角色表")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/user/role")
public class SystemUserRoleController implements CrudExcelController<SystemUserRole> {

    @Getter
    private final ISystemUserRoleService service;

}
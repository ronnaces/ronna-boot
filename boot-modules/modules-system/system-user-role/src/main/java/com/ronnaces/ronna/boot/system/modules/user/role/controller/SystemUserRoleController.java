package com.ronnaces.ronna.boot.system.modules.user.role.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.modules.user.role.service.ISystemUserRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "用户角色表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/user/role")
public class SystemUserRoleController implements CrudExcelController<SystemUserRole> {

    private final ISystemUserRoleService service;

}
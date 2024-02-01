package com.ronnaces.ronna.boot.system.management.user.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.user.service.ISystemUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SystemUserController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-29
 */
@Tag(name = "用户表")
@Slf4j
@AccessLogger
@AllArgsConstructor
@RestController
@RequestMapping("/v1/system/user")
public class SystemUserController implements CrudExcelController<SystemUser> {

    @Getter
    private final ISystemUserService service;

    /**
     * roles
     *
     * @return {@link Result}<{@link String}>
     */
    @Operation(summary = "查询用户的角色列表")
    @GetMapping(value = "/roles/{id:.+}")
    public Result<List<String>> roles(@Parameter(name = "id", required = true) @PathVariable(name = "id") String id) {
        return Result.success(service.roles(id));
    }
}
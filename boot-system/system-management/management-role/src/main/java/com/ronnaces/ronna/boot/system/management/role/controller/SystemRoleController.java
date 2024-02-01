package com.ronnaces.ronna.boot.system.management.role.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.management.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.management.role.service.ISystemRoleService;
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
 * SystemRoleController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Tag(name = "角色表")
@Slf4j
@AccessLogger
@AllArgsConstructor
@RestController
@RequestMapping("/v1/system/role")
public class SystemRoleController implements CrudExcelController<SystemRole> {

    @Getter
    private final ISystemRoleService service;

    /**
     * permission
     *
     * @return {@link Result}<{@link String}>
     */
    @GetMapping(value = "/permission/{id}")
    public Result<List<String>> permission(@PathVariable("id") String id) {
        return Result.success(service.permission(id));
    }

}
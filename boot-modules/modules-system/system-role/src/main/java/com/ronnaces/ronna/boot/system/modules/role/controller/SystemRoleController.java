package com.ronnaces.ronna.boot.system.modules.role.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "角色表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/role")
public class SystemRoleController implements CrudExcelController<SystemRole> {

    private final ISystemRoleService service;


    @GetMapping(value = "/permission/{id}")
    public Result<List<String>> permission(@PathVariable("id") String id) {
        return Result.success(service.permission(id));
    }

}
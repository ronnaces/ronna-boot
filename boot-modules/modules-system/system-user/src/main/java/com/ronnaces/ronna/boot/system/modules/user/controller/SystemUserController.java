package com.ronnaces.ronna.boot.system.modules.user.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.user.bean.request.AdjustStateRequest;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "用户表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/user")
public class SystemUserController implements CrudExcelController<SystemUser> {

    private final ISystemUserService service;

    @Operation(summary = "查询用户的角色列表")
    @GetMapping(value = "/roles/{id:.+}")
    public Result<List<String>> roles(@Parameter(name = "id", required = true) @PathVariable(name = "id") String id) {
        return Result.success(service.roles(id));
    }

    @Operation(summary = "调整用户状态")
    @PutMapping(value = "/adjust/state/{id:.+}")
    public Result<List<String>> adjustState(@RequestBody AdjustStateRequest request) {
        service.adjustState(request);
        return Result.success();
    }
}
package com.ronnaces.ronna.boot.system.modules.role.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.request.AdjustStateRequest;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public R<List<String>> permission(@PathVariable("id") String id) {
        return R.ok(service.permission(id));
    }

    @Operation(summary = "调整状态")
    @PutMapping(value = "/adjust/state/{id:.+}")
    public R<?> adjustState(@RequestBody AdjustStateRequest request) {
        service.adjustState(request);
        return R.ok();
    }

}
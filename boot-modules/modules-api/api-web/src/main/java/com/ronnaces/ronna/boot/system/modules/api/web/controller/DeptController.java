package com.ronnaces.ronna.boot.system.modules.api.web.controller;

import com.ronnaces.loong.common.entity.ListEntity;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.loong.core.annotation.EditLogger;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.dept.CreateDeptRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.dept.EditDeptRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.dept.DeptResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "部门API")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/dept")
public class DeptController {

    private final DeptService service;

    @Operation(summary = "创建")
    @EditLogger("创建")
    @PostMapping("/create")
    public R<Boolean> create(@RequestBody CreateDeptRequest payload) {
        return R.ok(service.create(payload));
    }

    @Operation(summary = "编辑")
    @EditLogger("编辑")
    @PostMapping("/edit")
    public R<Boolean> edit(@RequestBody EditDeptRequest payload) {
        return R.ok(service.edit(payload));
    }

    @Operation(summary = "调整状态")
    @PutMapping(value = "/edit/state")
    public R<?> editState(@RequestBody EditStateRequest request) {
        service.editState(request);
        return R.ok();
    }

    @Operation(summary = "列表")
    @PostMapping("/list")
    public R<List<DeptResponse>> list(@RequestBody ListEntity entity) {
        return R.ok(service.list(entity));
    }
}
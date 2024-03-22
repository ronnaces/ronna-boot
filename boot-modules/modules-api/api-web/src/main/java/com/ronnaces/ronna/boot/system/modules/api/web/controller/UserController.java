package com.ronnaces.ronna.boot.system.modules.api.web.controller;

import com.ronnaces.loong.common.entity.PageQEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.loong.core.annotation.EditLogger;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.user.CreateUserRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.user.EditUserRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.user.SystemUserRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.user.DepartmentResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.user.UserResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.service.UserService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "用户API")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService service;

    @Operation(summary = "创建")
    @EditLogger("创建")
    @PostMapping("/create")
    public R<Boolean> create(@RequestBody CreateUserRequest payload) {
        return R.ok(service.create(payload));
    }

    @Operation(summary = "编辑")
    @EditLogger("编辑")
    @PostMapping("/edit")
    public R<Boolean> edit(@RequestBody EditUserRequest payload) {
        return R.ok(service.edit(payload));
    }

    @Operation(summary = "查询角色编号列表")
    @GetMapping(value = "/role/{id:.+}")
    public R<List<String>> role(@Parameter(name = "id", required = true) @PathVariable(name = "id") String id) {
        return R.ok(service.role(id));
    }

    @Operation(summary = "调整状态")
    @PutMapping(value = "/edit/state")
    public R<?> editState(@RequestBody EditStateRequest request) {
        service.editState(request);
        return R.ok();
    }

    @Operation(summary = "分页列表")
    @PostMapping("/page")
    public R<PageResult<UserResponse>> page(@RequestBody PageQEntity<SystemUserRequest> entity) {
        return R.ok(service.page(entity));
    }

    @Operation(summary = "头像上传")
    @PostMapping("/avatar")
    public R<?> avatar(@RequestPart("file") MultipartFile file, @RequestParam("id") String id, HttpServletRequest request) {
        service.avatar(file, id, request);
        return R.ok();
    }

    @Operation(summary = "查询用户部门列表")
    @GetMapping(value = "/department")
    public R<List<DepartmentResponse>> userDepartment() {
        return R.ok(service.userDepartment());
    }

    @Operation(summary = "查询用户是否存在")
    @GetMapping(value = "/exist")
    public R<Boolean> exist(String username) {
        return R.ok(service.exist(username));
    }

    @Operation(summary = "唯一性校验")
    @GetMapping(value = "/unique")
    public R<?> unique(@RequestBody SystemUser entity) {
        if (service.unique(entity)) {
            return R.ok(Boolean.TRUE);
        } else {
            return R.ok(Boolean.FALSE);
        }
    }
}
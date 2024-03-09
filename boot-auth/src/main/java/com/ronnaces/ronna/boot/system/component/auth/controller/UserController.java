package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.Department;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.service.IUserService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "用户管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/auth/user")
public class UserController {

    private final IUserService service;

    @Operation(summary = "查询用户部门列表")
    @GetMapping(value = "/department")
    public Result<List<Department>> userDepartment() {
        return Result.success(service.userDepartment());
    }

    @Operation(summary = "查询用户信息")
    @GetMapping(value = "/info")
    public Result<UserResponse> info(Authentication authentication) {
        return Result.success(service.info(authentication.getName()));
    }

    @Operation(summary = "查询用户是否存在")
    @GetMapping(value = "/exist")
    public Result<Boolean> exist(String username) {
        return Result.success(service.exist(username));
    }

    @Operation(summary = "唯一性校验")
    @GetMapping(value = "/unique")
    public Result<?> unique(@RequestBody SystemUser entity) {
        if (service.unique(entity)) {
            return Result.success(Boolean.TRUE);
        } else {
            return Result.success(Boolean.FALSE);
        }
    }

}
package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.entity.R;
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
@RequestMapping("/v1/user")
public class UserController {

    private final IUserService service;

    @Operation(summary = "查询用户部门列表")
    @GetMapping(value = "/department")
    public R<List<Department>> userDepartment() {
        return R.ok(service.userDepartment());
    }

    @Operation(summary = "查询用户信息")
    @GetMapping(value = "/info")
    public R<UserResponse> info(Authentication authentication) {
        return R.ok(service.info(authentication.getName()));
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
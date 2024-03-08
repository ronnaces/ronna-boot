package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.LoginLogger;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.BindRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.*;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.component.auth.service.IAuthService;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "认证管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final IAuthService service;

    @Operation(summary = "用户密码登录")
    @LoginLogger(value = "用户密码登录")
    @PostMapping(value = "/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest entity, HttpServletRequest request) {
        return Result.success(service.login(entity, request));
    }

    @Operation(summary = "注册")
    @PostMapping(value = "/register")
    public Result<?> register(@RequestBody RegisterRequest entity) {
        service.register(entity);
        return Result.success();
    }
    
    @Operation(summary = "查询用户部门列表")
    @GetMapping(value = "/user/department")
    public Result<List<Department>> userDepartment() {
        return Result.success(service.userDepartment());
    }

    @Operation(summary = "查询用户信息")
    @GetMapping(value = "/user/info")
    public Result<UserResponse> userinfo(Authentication authentication) {
        return Result.success(service.userinfo(authentication.getName()));
    }

    @Operation(summary = "查询用户权限列表")
    @GetMapping(value = "/user/permission")
    public Result<List<String>> userPermission(Authentication authentication) {
        return Result.success(service.userPermission(authentication.getName()));
    }

    @Operation(summary = "查询用户是否存在")
    @GetMapping(value = "/user/exist")
    public Result<Boolean> userExist(String username) {
        return Result.success(service.userExist(username));
    }

    @Operation(summary = "唯一性校验")
    @GetMapping(value = "/check/uniqueness")
    public Result<?> checkUniqueness(@RequestBody SystemUser entity) {
        if (service.checkUniqueness(entity)) {
            return Result.success(Boolean.TRUE);
        } else {
            return Result.success(Boolean.FALSE);
        }
    }
    
    @Operation(summary = "修改密码")
    @PutMapping(value = "/change/password")
    public Result<?> changePassword(@RequestBody ChangePasswordRequest entity) {
        service.changePassword(entity);
        return Result.success();
    }

    @Operation(summary = "重置密码")
    @PutMapping(value = "/reset/password")
    public Result<?> resetPassword(@RequestParam("userId") String userId) {
        service.resetPassword(userId);
        return Result.success();
    }
    
    @Operation(summary = "查询角色路由列表")
    @GetMapping(value = "/role/routes")
    public Result<List<PermissionResponse>> roleRoutes(@RequestParam("roleId") String roleId) {
        return Result.success(service.roleRoutes(roleId));
    }
    
    @Operation(summary = "查询用户路由列表")
    @GetMapping(value = "/user/router")
    public Result<List<Router>> userRouter(Authentication authentication) {
        return Result.success(service.userRouter((WebUser) authentication.getPrincipal()));
    }

    @Operation(summary = "刷新Token")
    @GetMapping(value = "/refresh/token")
    public Result<RefreshTokenResponse> refreshToken(@RequestParam String refreshToken) {
        return Result.success(service.refreshToken(refreshToken));
    }

    @Operation(summary = "绑定角色")
    @PostMapping(value = "/user/bind/role")
    public Result<?> bindRole(@RequestBody BindRequest request) {
        service.bindRole(request.getMainId(), request.getMinorIds());
        return Result.success();
    }

    @Operation(summary = "绑定权限")
    @PostMapping(value = "/user/bind/permission")
    public Result<?> bindPermission(@RequestBody BindRequest request) {
        service.bindPermission(request.getMainId(), request.getMinorIds());
        return Result.success();
    }

    @Operation(summary = "绑定部门")
    @PostMapping(value = "/user/bind/department")
    public Result<?> bindDepartment(@RequestBody BindRequest request) {
        service.bindDepartment(request.getMainId(), request.getMinorIds());
        return Result.success();
    }
}
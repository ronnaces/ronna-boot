package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.LoginLogger;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.BindRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.*;
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

/**
 * 认证管理
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Tag(name = "认证管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final IAuthService service;

    /**
     * login
     *
     * @return {@link Result}<{@link LoginResponse}>
     */
    @Operation(summary = "用户密码登录")
    @LoginLogger(value = "用户密码登录")
    @PostMapping(value = "/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest entity, HttpServletRequest request) {
        return Result.success(service.login(entity, request));
    }

    /**
     * register
     *
     * @param entity entity
     * @return {@link Result}<{@link ?}>
     */
    @Operation(summary = "注册")
    @PostMapping(value = "/register")
    public Result<?> register(@RequestBody RegisterRequest entity) {
        service.register(entity);
        return Result.success();
    }

    /**
     * user department
     *
     * @return {@link Result}<{@link List}<{@link String}>>
     */
    @Operation(summary = "查询用户部门列表")
    @GetMapping(value = "/user/department")
    public Result<List<Department>> userDepartment() {
        return Result.success(service.userDepartment());
    }

    /**
     * user info
     *
     * @return {@link Result}<{@link UserResponse}>
     */
    @Operation(summary = "查询用户信息")
    @GetMapping(value = "/user/info")
    public Result<UserResponse> userinfo(Authentication authentication) {
        return Result.success(service.userinfo(authentication.getName()));
    }

    /**
     * user permission
     *
     * @return {@link Result}<{@link List}<{@link String}>>
     */
    @Operation(summary = "查询用户权限列表")
    @GetMapping(value = "/user/permission")
    public Result<List<String>> userPermission(Authentication authentication) {
        return Result.success(service.userPermission(authentication.getName()));
    }

    /**
     * user exist
     *
     * @return {@link Result}<<{@link Boolean}>
     */
    @Operation(summary = "查询用户是否存在")
    @GetMapping(value = "/user/exist")
    public Result<Boolean> userExist(String username) {
        return Result.success(service.userExist(username));
    }

    /**
     * check uniqueness
     *
     * @param entity entity
     * @return {@link Result}<{@link SystemUser}>
     */
    @Operation(summary = "唯一性校验")
    @GetMapping(value = "/check/uniqueness")
    public Result<?> checkUniqueness(@RequestBody SystemUser entity) {
        if (service.checkUniqueness(entity)) {
            return Result.success(Boolean.TRUE);
        } else {
            return Result.success(Boolean.FALSE);
        }
    }

    /**
     * change password
     *
     * @param entity entity
     * @return {@link Result}<{@link ?}>
     */
    @Operation(summary = "修改密码")
    @PutMapping(value = "/change/password")
    public Result<?> changePassword(@RequestBody ChangePasswordRequest entity) {
        service.changePassword(entity);
        return Result.success();
    }

    /**
     * reset password
     *
     * @param userId userId
     * @return {@link Result}<{@link ?}>
     */
    @Operation(summary = "重置密码")
    @PutMapping(value = "/reset/password")
    public Result<?> resetPassword(@RequestParam("userId") String userId) {
        service.resetPassword(userId);
        return Result.success();
    }

    /**
     * role routes
     *
     * @return {@link Result}<{@link SystemPermission}>
     */
    @Operation(summary = "查询角色路由列表")
    @GetMapping(value = "/role/routes")
    public Result<List<PermissionResponse>> roleRoutes(@RequestParam("roleId") String roleId) {
        return Result.success(service.roleRoutes(roleId));
    }

    /**
     * user router
     *
     * @param authentication authentication
     * @return {@link Result}<{@link List}<{@link Router}>>
     */
    @Operation(summary = "查询用户路由列表")
    @GetMapping(value = "/user/router")
    public Result<List<Router>> userRouter(Authentication authentication) {
        return Result.success(service.userRouter(authentication.getName()));
    }

    /**
     * refresh token
     *
     * @return {@link Result}<{@link SystemPermission}>
     */
    @Operation(summary = "刷新Token")
    @GetMapping(value = "/refresh/token")
    public Result<RefreshTokenResponse> refreshToken(@RequestParam String refreshToken) {
        return Result.success(service.refreshToken(refreshToken));
    }

    /**
     * bind role
     *
     * @return {@link Result}<{@link String}>
     */
    @Operation(summary = "绑定角色")
    @PostMapping(value = "/user/bind/role")
    public Result<?> bindRole(@RequestBody BindRequest request) {
        service.bindRole(request.getMainId(), request.getMinorIds());
        return Result.success();
    }

    /**
     * bind permission
     *
     * @return {@link Result}<{@link String}>
     */
    @Operation(summary = "绑定权限")
    @PostMapping(value = "/user/bind/permission")
    public Result<?> bindPermission(@RequestBody BindRequest request) {
        service.bindPermission(request.getMainId(), request.getMinorIds());
        return Result.success();
    }

    /**
     * bind department
     *
     * @return {@link Result}<{@link String}>
     */
    @Operation(summary = "绑定部门")
    @PostMapping(value = "/user/bind/department")
    public Result<?> bindDepartment(@RequestBody BindRequest request) {
        service.bindDepartment(request.getMainId(), request.getMinorIds());
        return Result.success();
    }
}
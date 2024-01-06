package com.ronnaces.ronna.boot.system.component.authentication.controller;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.LoginLogger;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.PermissionRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.RoleRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.response.*;
import com.ronnaces.ronna.boot.system.component.authentication.service.IAuthenticationService;
import com.ronnaces.ronna.boot.system.management.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AuthorizationController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     *
     */
    private final IAuthenticationService service;

    public AuthController(IAuthenticationService service) {
        this.service = service;
    }

    /**
     * login
     *
     * @return {@link Result}<{@link LoginResponse}>
     */
    @LoginLogger(value = "用户密码登录")
    @PostMapping(value = "/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest entity, HttpServletRequest request) throws Exception {
        return Result.success(service.login(entity, request));
    }

    /**
     * phone login
     *
     * @return {@link Result}<{@link RegisterRequest}>
     */
//    @AccessLogger
//    @PostMapping(value = "/login/phone")
//    public Result<?> loginPhone(@RequestBody LoginPhoneRequest entity, HttpServletRequest request) {
//        return Result.success(service.loginPhone(entity, request));
//    }

    /**
     * register
     *
     * @param entity entity
     * @return {@link Result}<{@link ?}>
     */
    @PostMapping(value = "/register")
    public Result<?> register(@RequestBody RegisterRequest entity) {
        service.register(entity);
        return Result.success();
    }

    /**
     * user info
     *
     * @return {@link Result}<{@link UserResponse}>
     */
    @GetMapping(value = "/user/info")
    public Result<UserResponse> userinfo(Authentication authentication) {
        return Result.success(service.userinfo(authentication.getName()));
    }

    /**
     * user permission
     *
     * @return {@link Result}<{@link List}<{@link String}>>
     */
    @GetMapping(value = "/user/permission")
    public Result<List<String>> userPermission(Authentication authentication) {
        return Result.success(service.userPermission(authentication.getName()));
    }

    /**
     * check uniqueness
     *
     * @param entity entity
     * @return {@link Result}<{@link SystemUser}>
     */
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
    @PutMapping(value = "/change/password")
    public Result<?> changePassword(@RequestBody SystemUser entity) {
        service.changePassword(entity);
        return Result.success();
    }

    /**
     * reset password
     *
     * @param entity entity
     * @return {@link Result}<{@link ?}>
     */
    @PutMapping(value = "/reset/password")
    public Result<?> resetPassword(@RequestBody SystemUser entity) {
        service.resetPassword(entity);
        return Result.success();
    }

    /**
     * role routes
     *
     * @return {@link Result}<{@link SystemPermission}>
     */
    @GetMapping(value = "/role/routes")
    public Result<List<SystemPermission>> roleRoutes(@RequestParam("roleId") String roleId) {
        return Result.success(service.roleRoutes(roleId));
    }

    /**
     * user routes
     *
     * @return {@link Result}<{@link RouteResponse}>
     */
    @GetMapping(value = "/user/routes")
    public Result<List<RouteResponse>> userRoutes(Authentication authentication) {
        return Result.success(service.userRoutes(authentication.getName()));
    }

    /**
     * user router
     *
     * @param authentication authentication
     * @return {@link Result}<{@link List}<{@link Router}>>
     */
    @GetMapping(value = "/user/router")
    public Result<List<Router>> userRouter(Authentication authentication) {
        return Result.success(service.userRouter(authentication.getName()));
    }

    /**
     * routes
     *
     * @return {@link Result}<{@link RouteResponse}>
     */
    @GetMapping(value = "/tree/routes")
    public Result<List<RouteResponse>> treeRoutes() {
        return Result.success(service.treeRoutes());
    }

    /**
     * refresh token
     *
     * @return {@link Result}<{@link SystemPermission}>
     */
    @GetMapping(value = "/refresh/token")
    public Result<RefreshTokenResponse> refreshToken(@RequestParam String refreshToken) {
        return Result.success(service.refreshToken(refreshToken));
    }

    /**
     * bind role
     *
     * @return {@link Result}<{@link String}>
     */
    @PostMapping(value = "/bind/role")
    public Result<?> bindRole(@RequestBody RoleRequest roleBind) {
        service.bindRole(roleBind.getUserId(), roleBind.getRoles());
        return Result.success();
    }

    /**
     * bind permission
     *
     * @return {@link Result}<{@link String}>
     */
    @PostMapping(value = "/bind/permission")
    public Result<?> bindPermission(@RequestBody PermissionRequest permissionBind) {
        service.bindPermission(permissionBind.getRoleId(), permissionBind.getPermissions());
        return Result.success();
    }

}
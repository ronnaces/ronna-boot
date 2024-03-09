package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.LoginLogger;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.LoginResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.RefreshTokenResponse;
import com.ronnaces.ronna.boot.system.component.auth.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


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

    @Operation(summary = "刷新Token")
    @GetMapping(value = "/refresh/token")
    public Result<RefreshTokenResponse> refreshToken(@RequestParam String refreshToken) {
        return Result.success(service.refreshToken(refreshToken));
    }
}
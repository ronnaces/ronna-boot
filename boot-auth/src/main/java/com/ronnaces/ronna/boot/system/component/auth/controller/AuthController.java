package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.LoginLogger;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RefreshTokenRequest;
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
    public R<LoginResponse> login(@RequestBody LoginRequest entity, HttpServletRequest request) {
        return R.ok(service.login(entity, request));
    }

    @Operation(summary = "注册")
    @PostMapping(value = "/register")
    public R<?> register(@RequestBody RegisterRequest entity) {
        service.register(entity);
        return R.ok();
    }

    @Operation(summary = "刷新Token")
    @PostMapping(value = "/refresh/token")
    public R<RefreshTokenResponse> refreshToken(@RequestBody RefreshTokenRequest entity, HttpServletRequest request) {
        return R.ok(service.refreshToken(entity, request));
    }
}
package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.R;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ProfileRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.service.IProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@Tag(name = "个人中心")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/profile")
public class ProfileController {

    private final IProfileService service;

    @Operation(summary = "查询信息")
    @GetMapping
    public R<UserResponse> detail(Authentication authentication) {
        return R.ok(service.detail(authentication.getName()));
    }

    @Operation(summary = "修改信息")
    @PutMapping
    public R<?> edit(Authentication authentication, @RequestBody ProfileRequest request) {
        service.edit(authentication.getName(), request);
        return R.ok();
    }

    @Operation(summary = "重置密码")
    @PutMapping(value = "/reset/password")
    public R<?> resetPassword(Authentication authentication) {
        service.resetPassword(authentication.getName());
        return R.ok();
    }
}
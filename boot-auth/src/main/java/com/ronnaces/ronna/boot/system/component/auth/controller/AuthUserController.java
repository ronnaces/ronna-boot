package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.entity.R;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.component.auth.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "用户管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class AuthUserController {

    private final IUserService service;

    @Operation(summary = "查询用户信息")
    @GetMapping(value = "/info")
    public R<UserResponse> info(Authentication authentication) {
        return R.ok(service.info(authentication.getName()));
    }

}
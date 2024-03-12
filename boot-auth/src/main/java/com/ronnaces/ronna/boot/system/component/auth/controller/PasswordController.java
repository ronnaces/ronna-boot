package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.R;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.service.IPasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Tag(name = "密码管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/password")
public class PasswordController {

    private final IPasswordService service;

    @Operation(summary = "修改密码")
    @PutMapping(value = "/change")
    public R<?> changePassword(@RequestBody ChangePasswordRequest entity) {
        service.changePassword(entity);
        return R.ok();
    }

    @Operation(summary = "重置密码")
    @PutMapping(value = "/reset")
    public R<?> resetPassword(@RequestParam("userId") String userId) {
        service.resetPassword(userId);
        return R.ok();
    }
}
package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.entity.R;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.CaptchaRequest;
import com.ronnaces.ronna.boot.system.component.auth.service.ICaptchaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Tag(name = "校验码管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/auth/captcha")
public class CaptchaController {

    private final ICaptchaService service;

    @Operation(summary = "生成校验码")
    @GetMapping
    public R<CaptchaRequest> captcha() {
        return R.ok(service.captcha());
    }

    @Operation(summary = "检查校验码")
    @PostMapping(value = "/check")
    public R<Boolean> checkCaptcha(@RequestBody CaptchaRequest entity) {
        return R.ok(service.checkCaptcha(entity));
    }
}
package com.ronnaces.ronna.boot.system.component.auth.controller;


import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.CaptchaRequest;
import com.ronnaces.ronna.boot.system.component.auth.service.ICaptchaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * CaptchaController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Tag(name = "校验码管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/auth/captcha")
public class CaptchaController {

    private final ICaptchaService service;

    /**
     * captcha
     *
     * @return {@link Result}<{@link CaptchaRequest}>
     */
    @Operation(summary = "生成校验码")
    @GetMapping
    public Result<CaptchaRequest> captcha() {
        return Result.success(service.captcha());
    }

    /**
     * check captcha
     *
     * @return {@link Result}<{@link CaptchaRequest}>
     */
    @Operation(summary = "检查校验码")
    @PostMapping(value = "/check")
    public Result<Boolean> checkCaptcha(@RequestBody CaptchaRequest entity) {
        return Result.success(service.checkCaptcha(entity));
    }
}
package com.ronnaces.ronna.boot.system.component.auth.controller;


import com.ronnaces.ronna.boot.system.component.auth.bean.request.CaptchaRequest;
import com.ronnaces.ronna.boot.system.component.auth.service.ICaptchaService;
import com.ronnaces.loong.common.controller.Result;import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * CaptchaController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Slf4j
@RestController
@RequestMapping("/auth/captcha")
public class CaptchaController {

    private final ICaptchaService service;

    public CaptchaController(ICaptchaService service) {
        this.service = service;
    }

    /**
     * captcha
     *
     * @return {@link Result}<{@link CaptchaRequest}>
     */
    @GetMapping
    public Result<CaptchaRequest> captcha() {
        return Result.success(service.captcha());
    }

    /**
     * check captcha
     *
     * @return {@link Result}<{@link CaptchaRequest}>
     */
    @PostMapping(value = "/check")
    public Result<Boolean> checkCaptcha(@RequestBody CaptchaRequest entity) {
        return Result.success(service.checkCaptcha(entity));
    }
}
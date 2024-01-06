package com.ronnaces.ronna.boot.system.component.authentication.service;

import com.ronnaces.ronna.boot.system.component.authentication.bean.request.CaptchaRequest;

/**
 * ICaptchaService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
public interface ICaptchaService {

    /**
     * captcha
     *
     * @return {@link CaptchaRequest}
     */
    CaptchaRequest captcha();

    /**
     * check captcha
     *
     * @param captchaRequest captcha
     */
    Boolean checkCaptcha(CaptchaRequest captchaRequest);
}

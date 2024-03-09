package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.CaptchaRequest;


public interface ICaptchaService {


    CaptchaRequest captcha();


    Boolean checkCaptcha(CaptchaRequest captchaRequest);
}

package com.ronnaces.ronna.boot.system.component.authentication.service.impl;

import com.ronnaces.ronna.boot.system.component.authentication.bean.request.CaptchaRequest;
import com.ronnaces.loong.autoconfigure.redis.component.RedisStringComponent;
import com.ronnaces.ronna.boot.system.component.authentication.service.ICaptchaService;
import com.ronnaces.loong.core.captcha.SpecCaptcha;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * CaptchaServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Service
public class CaptchaServiceImpl implements ICaptchaService {

    private static final String CAPTCHA = "captcha";

    private final RedisStringComponent redisStringComponent;

    public CaptchaServiceImpl(RedisStringComponent redisStringComponent) {
        this.redisStringComponent = redisStringComponent;
    }

    @Override
    public CaptchaRequest captcha() {
        SpecCaptcha captcha = new SpecCaptcha();
        String base64 = captcha.toBase64();
        String text = captcha.text();
        String key = UUID.randomUUID().toString();
        redisStringComponent.set(CAPTCHA, text);
        return CaptchaRequest.builder().key(key).code(base64).text(text).build();
    }

    @Override
    public Boolean checkCaptcha(CaptchaRequest captchaRequest) {
        String checkValue = captchaRequest.getText();
        String value = redisStringComponent.get(CAPTCHA);
        if (Objects.nonNull(value) && StringUtils.equalsIgnoreCase(value, checkValue)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}


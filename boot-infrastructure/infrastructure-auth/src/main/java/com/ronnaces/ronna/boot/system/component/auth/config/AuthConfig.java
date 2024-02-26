package com.ronnaces.ronna.boot.system.component.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

/**
 * AuthConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/11/28 16:32
 */
@RequiredArgsConstructor
@Configuration
public class AuthConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B, new SecureRandom());
    }
}

package com.ronnaces.ronna.boot.system.component.api.config;

import com.ronnaces.ronna.boot.system.component.api.interceptor.SignatureInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SignatureInterceptorConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 20:49
 */
@Configuration
public class SignatureInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public SignatureInterceptor signInterceptor() {
        return new SignatureInterceptor();
    }

}

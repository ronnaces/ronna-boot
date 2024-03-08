package com.ronnaces.ronna.boot.system.component.api.config;

import com.ronnaces.ronna.boot.system.component.api.interceptor.SignatureInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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

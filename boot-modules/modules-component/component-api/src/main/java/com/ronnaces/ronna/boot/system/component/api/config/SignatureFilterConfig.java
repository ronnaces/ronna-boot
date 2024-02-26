package com.ronnaces.ronna.boot.system.component.api.config;

import com.ronnaces.ronna.boot.system.component.api.filter.SignatureFilter;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SignatureFilterConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 20:49
 */
@Configuration
public class SignatureFilterConfig {

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SignatureFilter());
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("signatureFilter");
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }

}


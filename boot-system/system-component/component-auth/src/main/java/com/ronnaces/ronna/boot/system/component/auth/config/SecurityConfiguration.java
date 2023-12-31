package com.ronnaces.ronna.boot.system.component.auth.config;

import com.ronnaces.ronna.boot.system.component.auth.filter.JwtAuthenticationFilter;
import com.ronnaces.ronna.boot.system.component.auth.handler.AccessDeniedHandlerComponent;
import com.ronnaces.ronna.boot.system.component.auth.handler.AuthenticationEntryPointImpl;
import com.ronnaces.ronna.boot.system.component.auth.handler.LogoutAuthenticationHandler;
import com.ronnaces.ronna.boot.system.component.auth.handler.LogoutAuthenticationSuccessHandler;
import com.ronnaces.ronna.boot.system.component.auth.service.PhoneUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    public static final List<String> WHITE_LIST_URL = Arrays.asList(
            "/webjars/**",
            "/images/**",
            "/css/**",
            "/**.html",
            "/**.css",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/favicon.ico"
    );
    private final AccessDeniedHandlerComponent accessDeniedHandlerComponent;
    private final LogoutAuthenticationSuccessHandler logoutAuthenticationSuccessHandler;
    private final AuthenticationEntryPointImpl authenticationEntryPointImpl;
    private final AuthProperties authProperties;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final LogoutAuthenticationHandler logoutAuthenticationHandler;
    private final PhoneUserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                            WHITE_LIST_URL.forEach(url -> authorize.requestMatchers(url).permitAll());
                            authProperties.getPermits().forEach(url -> authorize.requestMatchers(url).permitAll());
                            authorize.anyRequest().authenticated();
                        }
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
//                .authenticationProvider(phoneVerificationCodeAuthenticationProvider)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(accessDeniedHandlerComponent)
                        .authenticationEntryPoint(authenticationEntryPointImpl)
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID")
                        .logoutUrl("/auth/logout")
                        .addLogoutHandler(logoutAuthenticationHandler)
                        .logoutSuccessHandler(logoutAuthenticationSuccessHandler)
                        .invalidateHttpSession(true)
                )
                .headers((headers) -> headers
                        .contentTypeOptions(withDefaults())
                        .xssProtection(withDefaults())
                        .cacheControl(withDefaults())
                        .httpStrictTransportSecurity(withDefaults())
                        .frameOptions(withDefaults()))
                .build();
    }
}

package com.ronnaces.ronna.boot.cors;

import org.springframework.context.annotation.Configuration;

/**
 * CorsConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/12/22 16:26
 */
@Configuration
public class CorsConfig {
/*    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 允许cookies跨域
        configuration.setAllowCredentials(true);
        // #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        configuration.addAllowedOriginPattern("*");
        // #允许访问的头信息,*表示全部
        configuration.addAllowedHeader("*");
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        configuration.setMaxAge(18000L);
        // 允许提交请求的方法，*表示全部允许
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/
}

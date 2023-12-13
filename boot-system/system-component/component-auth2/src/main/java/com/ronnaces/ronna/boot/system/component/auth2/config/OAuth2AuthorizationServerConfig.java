package com.ronnaces.ronna.boot.system.component.auth2.config;

//@AllArgsConstructor
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class OAuth2AuthorizationServerConfig {

//    private final AccessDeniedHandler accessDeniedHandler;
//
//    private final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;
//
//    private final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;
//
//    /**
//     * 认证失败过滤器
//     */
//    private final AuthenticationEntryPoint authenticationEntryPoint;
//
//    /**
//     * Token 认证过滤器 Bean
//     */
//    private final JwtAuthenticationFilter authenticationTokenFilter;
//
//    private final AuthorizationProperties authorizationProperties;
//
//    private final RegisteredClientRepository registeredClientRepository;
//
//    /**
//     * 由于 Spring Security 创建 AuthenticationManager 对象时，没声明 @Bean 注解，导致无法被注入，通过覆写父类的该方法，添加 @Bean 注解，解决该问题
//     */
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    /**
//     * 配置 URL 的安全配置
//     * <p>
//     * anyRequest          |   匹配所有请求路径
//     * <p>
//     * access              |   SpringEl表达式结果为true时可以访问
//     * <p>
//     * anonymous           |   匿名可以访问
//     * <p>
//     * denyAll             |   用户不能访问
//     * <p>
//     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
//     * <p>
//     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
//     * <p>
//     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
//     * <p>
//     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
//     * <p>
//     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
//     * <p>
//     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
//     * <p>
//     * permitAll           |   用户可以任意访问
//     * <p>
//     * rememberMe          |   允许通过remember-me登录的用户访问
//     * <p>
//     * authenticated       |   用户登录后可访问
//     */
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http)
//            throws Exception {
//        OAuth2AuthorizationServerConfigurer serverConfigurer = new OAuth2AuthorizationServerConfigurer();
//        http.apply(serverConfigurer);
//        serverConfigurer.registeredClientRepository(registeredClientRepository);
//
//        //设置客户端授权中失败的handler处理
////        serverConfigurer.clientAuthentication((auth) -> auth.errorResponseHandler(loginAuthenticationFailureHandler))
////                //token 相关配置 如  /oauth2/token接口
////                .tokenEndpoint((token) -> token.errorResponseHandler(loginAuthenticationFailureHandler))
////                .oidc(oidc -> oidc.userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userInfoMapper(context -> {
////                    OAuth2AccessToken accessToken = context.getAccessToken();
////                    Map<String, Object> claims = new HashMap<>();
////                    claims.put("url", "https://github.com/ITLab1024");
////                    claims.put("accessToken", accessToken);
////                    claims.put("sub", context.getAuthorization().getPrincipalName());
////                    return new OidcUserInfo(claims);
////                }))
////                );
//        serverConfigurer.oidc(Customizer.withDefaults());
//
//        http
//                .securityMatcher(serverConfigurer.getEndpointsMatcher())
//                // 开启跨域
//                .cors(Customizer.withDefaults())
//                // 禁用CSRF，因为不使用Session
//                .csrf(AbstractHttpConfigurer::disable)
//                // 基于 token 机制，所以不需要 Session
//                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .formLogin(formLogin -> formLogin
//                        .successHandler(loginAuthenticationSuccessHandler)
//                        .failureHandler(loginAuthenticationFailureHandler)
//                )
//                // 设置每个请求的限制规则
//                .authorizeRequests(authorize -> authorize
//                        // 静态资源可匿名访问
//                        .requestMatchers(authorizationProperties.getStaticUrl().toArray(new String[0])).permitAll()
//                        // 配置的方法URL无需认证
//                        .requestMatchers(authorizationProperties.getPermitUrl().toArray(new String[0])).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .exceptionHandling(exceptions -> exceptions
//                        .accessDeniedHandler(accessDeniedHandler)
//                        .authenticationEntryPoint(authenticationEntryPoint)
//                )
//                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                .headers(Customizer.withDefaults())
//                .oauth2ResourceServer((resourceServer) -> resourceServer.jwt(Customizer.withDefaults()))
//        ;
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.addAllowedOrigin("*");
//        config.setAllowCredentials(true);
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//
//    @Bean
//    OAuth2TokenCustomizer<JwtEncodingContext> tokenCustomizer() {
//        return context -> {
//            Authentication principal = context.getPrincipal();
//            if (OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
//                Set<String> authorities = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
//                context.getClaims().claim("authorities", authorities);
//            }
//        };
//    }
//
//    @Bean
//    public JWKSource<SecurityContext> jwkSource() {
//        KeyPair keyPair = generateRsaKey();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        RSAKey rsaKey = new RSAKey.Builder(publicKey)
//                .privateKey(privateKey)
//                .keyID(UUID.randomUUID().toString())
//                .build();
//        JWKSet jwkSet = new JWKSet(rsaKey);
//        return new ImmutableJWKSet<>(jwkSet);
//    }
//
//    private static KeyPair generateRsaKey() {
//        KeyPair keyPair;
//        try {
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            keyPairGenerator.initialize(2048);
//            keyPair = keyPairGenerator.generateKeyPair();
//        } catch (Exception ex) {
//            throw new IllegalStateException(ex);
//        }
//        return keyPair;
//    }
//
//    @Bean
//    public AuthorizationServerSettings authorizationServerSettings() {
//        return AuthorizationServerSettings.builder().build();
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
//        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
//    }
//
//    @Bean
//    JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
//        grantedAuthoritiesConverter.setAuthorityPrefix("");
//
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
//        return jwtAuthenticationConverter;
//    }
}

package com.ronnaces.ronna.boot.mqtt.component.controller;

import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.mqtt.component.service.IMqttService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MQTT管理
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Tag(name = "MQTT管理")
@Slf4j
@AccessLogger
@RestController
@AllArgsConstructor
@RequestMapping("/v1/app")
public class MqttController {

    private final IMqttService service;

//    @Operation(summary = "App用户登录")
//    @PostMapping(value = "/login")
//    public Result<LoginResponse> login(@RequestBody LoginRequest entity, HttpServletRequest request) {
//        return Result.success(service.login(entity, request));
//    }
}
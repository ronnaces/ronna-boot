package com.ronnaces.ronna.boot.system.modules.login.log.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.modules.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.modules.login.log.service.ISystemLoginLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录日志表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2024-01-10
 */
@Tag(name = "登录日志表")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/system/login/log")
public class SystemLoginLogController implements CrudExcelController<SystemLoginLog> {

    @Getter
    private final ISystemLoginLogService service;

}
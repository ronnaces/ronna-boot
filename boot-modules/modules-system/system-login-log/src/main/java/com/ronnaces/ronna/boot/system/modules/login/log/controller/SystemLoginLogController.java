package com.ronnaces.ronna.boot.system.modules.login.log.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.modules.login.log.service.ISystemLoginLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "登录日志表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/login/log")
public class SystemLoginLogController implements CrudExcelController<SystemLoginLog> {

    private final ISystemLoginLogService service;

}
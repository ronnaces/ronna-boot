package com.ronnaces.ronna.boot.system.management.login.log.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.management.login.log.service.ISystemLoginLogService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemLoginLogController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/login/log")
public class SystemLoginLogController implements CrudExcelController<SystemLoginLog> {

    @Getter
    private final ISystemLoginLogService service;

}
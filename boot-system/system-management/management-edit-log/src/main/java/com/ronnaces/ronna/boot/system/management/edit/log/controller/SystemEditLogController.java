package com.ronnaces.ronna.boot.system.management.edit.log.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.edit.log.entity.SystemEditLog;
import com.ronnaces.ronna.boot.system.management.edit.log.service.ISystemEditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作日志表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2024-01-10
 */
@Tag(name = "操作日志表")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/edit/log")
public class SystemEditLogController implements CrudExcelController<SystemEditLog> {

    @Getter
    private final ISystemEditLogService service;

}
package com.ronnaces.ronna.boot.system.modules.edit.log.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.edit.log.entity.SystemEditLog;
import com.ronnaces.ronna.boot.system.modules.edit.log.service.ISystemEditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "操作日志表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/edit/log")
public class SystemEditLogController implements CrudExcelController<SystemEditLog> {

    private final ISystemEditLogService service;

}
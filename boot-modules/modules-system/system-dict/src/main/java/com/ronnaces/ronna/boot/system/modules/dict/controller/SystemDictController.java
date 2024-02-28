package com.ronnaces.ronna.boot.system.modules.dict.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.dict.entity.SystemDict;
import com.ronnaces.ronna.boot.system.modules.dict.service.ISystemDictService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Tag(name = "字典表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/dict")
public class SystemDictController implements CrudExcelController<SystemDict> {

    private final ISystemDictService service;

}
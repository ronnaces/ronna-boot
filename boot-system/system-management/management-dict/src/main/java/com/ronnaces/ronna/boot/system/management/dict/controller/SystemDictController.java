package com.ronnaces.ronna.boot.system.management.dict.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.dict.entity.SystemDict;
import com.ronnaces.ronna.boot.system.management.dict.service.ISystemDictService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/system/dict")
public class SystemDictController implements CrudExcelController<SystemDict> {

    @Getter
    private final ISystemDictService service;

}
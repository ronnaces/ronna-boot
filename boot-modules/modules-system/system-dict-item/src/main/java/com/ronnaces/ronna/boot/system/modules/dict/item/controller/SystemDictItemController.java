package com.ronnaces.ronna.boot.system.modules.dict.item.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.dict.item.entity.SystemDictItem;
import com.ronnaces.ronna.boot.system.modules.dict.item.service.ISystemDictItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "字典项目表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/dict/item")
public class SystemDictItemController implements CrudExcelController<SystemDictItem> {

    private final ISystemDictItemService service;

}
package com.ronnaces.ronna.boot.system.management.dict.item.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.dict.item.entity.SystemDictItem;
import com.ronnaces.ronna.boot.system.management.dict.item.service.ISystemDictItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemDictItemController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Tag(name = "字典项目表")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/dict/item")
public class SystemDictItemController implements CrudExcelController<SystemDictItem> {

    @Getter
    private final ISystemDictItemService service;

}
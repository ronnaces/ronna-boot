package com.ronnaces.ronna.boot.system.modules.department.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Tag(name = "部门表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/department")
public class SystemDepartmentController implements CrudExcelController<SystemDepartment> {

    private final ISystemDepartmentService service;

}
package com.ronnaces.ronna.boot.system.management.department.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.management.department.service.ISystemDepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemDepartmentController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/department")
public class SystemDepartmentController implements CrudExcelController<SystemDepartment> {

    @Getter
    private final ISystemDepartmentService service;

}
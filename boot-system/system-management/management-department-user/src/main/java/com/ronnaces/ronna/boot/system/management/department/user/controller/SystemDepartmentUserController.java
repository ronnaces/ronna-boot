package com.ronnaces.ronna.boot.system.management.department.user.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.department.user.entity.SystemDepartmentUser;
import com.ronnaces.ronna.boot.system.management.department.user.service.ISystemDepartmentUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemDepartmentUserController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/department/user")
public class SystemDepartmentUserController implements CrudExcelController<SystemDepartmentUser> {

    @Getter
    private final ISystemDepartmentUserService service;

}
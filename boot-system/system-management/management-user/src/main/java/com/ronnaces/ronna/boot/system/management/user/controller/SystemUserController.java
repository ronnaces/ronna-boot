package com.ronnaces.ronna.boot.system.management.user.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SystemUserController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-29
 */
@Slf4j
@AccessLogger
@AllArgsConstructor
@RestController
@RequestMapping("/system/user")
public class SystemUserController implements CrudExcelController<SystemUser> {

    @Getter
    private final ISystemUserService service;

    /**
     * roles
     *
     * @return {@link Result}<{@link String}>
     */
    @GetMapping(value = "/roles")
    public Result<List<String>> roles(@RequestParam("id") String id) {
        return Result.success(service.roles(id));
    }

}
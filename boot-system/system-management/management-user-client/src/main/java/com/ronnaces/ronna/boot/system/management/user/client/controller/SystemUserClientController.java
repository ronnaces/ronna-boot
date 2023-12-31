package com.ronnaces.ronna.boot.system.management.user.client.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.user.client.entity.SystemUserClient;
import com.ronnaces.ronna.boot.system.management.user.client.service.ISystemUserClientService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemUserClientController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/user/client")
public class SystemUserClientController implements CrudExcelController<SystemUserClient> {

    @Getter
    private final ISystemUserClientService service;

}
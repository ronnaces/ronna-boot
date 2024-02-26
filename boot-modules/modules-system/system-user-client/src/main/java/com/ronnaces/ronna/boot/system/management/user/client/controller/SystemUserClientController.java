package com.ronnaces.ronna.boot.system.modules.user.client.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.modules.user.client.entity.SystemUserClient;
import com.ronnaces.ronna.boot.system.modules.user.client.service.ISystemUserClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "用户客户端表")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/system/user/client")
public class SystemUserClientController implements CrudExcelController<SystemUserClient> {

    @Getter
    private final ISystemUserClientService service;

}
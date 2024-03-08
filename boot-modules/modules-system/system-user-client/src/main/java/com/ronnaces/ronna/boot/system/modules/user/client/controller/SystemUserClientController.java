package com.ronnaces.ronna.boot.system.modules.user.client.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.user.client.entity.SystemUserClient;
import com.ronnaces.ronna.boot.system.modules.user.client.service.ISystemUserClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "用户客户端表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/user/client")
public class SystemUserClientController implements CrudExcelController<SystemUserClient> {

    private final ISystemUserClientService service;

}
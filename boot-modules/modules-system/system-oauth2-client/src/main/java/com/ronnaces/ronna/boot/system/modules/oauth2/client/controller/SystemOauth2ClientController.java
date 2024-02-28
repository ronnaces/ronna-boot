package com.ronnaces.ronna.boot.system.modules.oauth2.client.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.oauth2.client.entity.SystemOauth2Client;
import com.ronnaces.ronna.boot.system.modules.oauth2.client.service.ISystemOauth2ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemOauth2ClientController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@Tag(name = "OAuth2客户端表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/oauth2/client")
public class SystemOauth2ClientController implements CrudExcelController<SystemOauth2Client> {

    private final ISystemOauth2ClientService service;

}
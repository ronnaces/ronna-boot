package com.ronnaces.ronna.boot.system.management.oauth2.client.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.ronna.boot.system.management.oauth2.client.entity.SystemOauth2Client;
import com.ronnaces.ronna.boot.system.management.oauth2.client.service.ISystemOauth2ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/system/oauth2/client")
public class SystemOauth2ClientController implements CrudExcelController<SystemOauth2Client> {

    @Getter
    private final ISystemOauth2ClientService service;

}
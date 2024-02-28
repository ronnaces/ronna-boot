package com.ronnaces.ronna.boot.system.modules.oauth2.refresh.token.controller;


import com.ronnaces.loong.common.controller.CrudExcelController;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.oauth2.refresh.token.entity.SystemOauth2RefreshToken;
import com.ronnaces.ronna.boot.system.modules.oauth2.refresh.token.service.ISystemOauth2RefreshTokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemOauth2RefreshTokenController
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@Tag(name = "Oauth2刷新Token表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/oauth2/refresh/token")
public class SystemOauth2RefreshTokenController implements CrudExcelController<SystemOauth2RefreshToken> {

    private final ISystemOauth2RefreshTokenService service;

}
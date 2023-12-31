package com.ronnaces.ronna.boot.system.management.oauth2.refresh.token.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.oauth2.refresh.token.entity.SystemOauth2RefreshToken;
import com.ronnaces.ronna.boot.system.management.oauth2.refresh.token.mapper.SystemOauth2RefreshTokenMapper;
import com.ronnaces.ronna.boot.system.management.oauth2.refresh.token.service.ISystemOauth2RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemOauth2RefreshTokenServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@AllArgsConstructor
@Service
public class SystemOauth2RefreshTokenServiceImpl extends ServiceImpl<SystemOauth2RefreshTokenMapper, SystemOauth2RefreshToken> implements ISystemOauth2RefreshTokenService {

    private final SystemOauth2RefreshTokenMapper mapper;

}


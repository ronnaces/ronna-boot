package com.ronnaces.ronna.boot.system.modules.oauth2.client.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.oauth2.client.entity.SystemOauth2Client;
import com.ronnaces.ronna.boot.system.modules.oauth2.client.mapper.SystemOauth2ClientMapper;
import com.ronnaces.ronna.boot.system.modules.oauth2.client.service.ISystemOauth2ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemOauth2ClientServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@AllArgsConstructor
@Service
public class SystemOauth2ClientServiceImpl extends ServiceImpl<SystemOauth2ClientMapper, SystemOauth2Client> implements ISystemOauth2ClientService {

    private final SystemOauth2ClientMapper mapper;

}


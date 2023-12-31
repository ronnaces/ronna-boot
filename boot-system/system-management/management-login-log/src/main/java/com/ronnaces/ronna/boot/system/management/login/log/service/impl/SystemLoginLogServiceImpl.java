package com.ronnaces.ronna.boot.system.management.login.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.management.login.log.mapper.SystemLoginLogMapper;
import com.ronnaces.ronna.boot.system.management.login.log.service.ISystemLoginLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemLoginLogServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@AllArgsConstructor
@Service
public class SystemLoginLogServiceImpl extends ServiceImpl<SystemLoginLogMapper, SystemLoginLog> implements ISystemLoginLogService {

    private final SystemLoginLogMapper mapper;

}


package com.ronnaces.ronna.boot.system.management.edit.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.edit.log.entity.SystemEditLog;
import com.ronnaces.ronna.boot.system.management.edit.log.mapper.SystemEditLogMapper;
import com.ronnaces.ronna.boot.system.management.edit.log.service.ISystemEditLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemEditLogServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@AllArgsConstructor
@Service
public class SystemEditLogServiceImpl extends ServiceImpl<SystemEditLogMapper, SystemEditLog> implements ISystemEditLogService {

    private final SystemEditLogMapper mapper;

}


package com.ronnaces.ronna.boot.system.modules.edit.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.edit.log.entity.SystemEditLog;
import com.ronnaces.ronna.boot.system.modules.edit.log.mapper.SystemEditLogMapper;
import com.ronnaces.ronna.boot.system.modules.edit.log.service.ISystemEditLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 操作日志表
 *
 * @author KunLong-Luo
 * @since 2024-01-10
 */
@AllArgsConstructor
@Service
public class SystemEditLogServiceImpl extends ServiceImpl<SystemEditLogMapper, SystemEditLog> implements ISystemEditLogService {
    private final SystemEditLogMapper mapper;
}

package com.ronnaces.ronna.boot.system.modules.user.client.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.user.client.entity.SystemUserClient;
import com.ronnaces.ronna.boot.system.modules.user.client.mapper.SystemUserClientMapper;
import com.ronnaces.ronna.boot.system.modules.user.client.service.ISystemUserClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemUserClientServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@AllArgsConstructor
@Service
public class SystemUserClientServiceImpl extends ServiceImpl<SystemUserClientMapper, SystemUserClient> implements ISystemUserClientService {

    private final SystemUserClientMapper mapper;

}

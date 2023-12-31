package com.ronnaces.ronna.boot.system.management.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.user.mapper.SystemUserMapper;
import com.ronnaces.ronna.boot.system.management.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SystemUserServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-29
 */
@AllArgsConstructor
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    private final SystemUserMapper mapper;

    @Override
    public List<String> roles(String id) {
        return mapper.findAllRoleCodeById(id);
    }
}


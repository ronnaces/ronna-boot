package com.ronnaces.ronna.boot.system.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.mapper.SystemUserMapper;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    private final SystemUserMapper mapper;

    @Override
    public List<String> roles(String id) {
        return mapper.findAllRoleCodeById(id);
    }

    @Override
    public SystemUser findByUsername(String userName) {
        return mapper.findByUsername(userName);
    }
}


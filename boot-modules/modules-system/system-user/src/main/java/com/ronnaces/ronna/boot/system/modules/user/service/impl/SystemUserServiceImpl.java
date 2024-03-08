package com.ronnaces.ronna.boot.system.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.ronna.boot.system.modules.user.bean.request.AdjustStateRequest;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.mapper.SystemUserMapper;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    private final SystemUserMapper mapper;

    @Override
    public List<String> roles(String id) {
        return mapper.findAllRoleCodeById(id);
    }

    @Override
    public SystemUser find(String username) {
        return Optional.ofNullable(mapper.findByUsername(username)).orElseThrow(() -> new LoongException("当前用户不存在"));
    }

    @Override
    public void adjustState(AdjustStateRequest request) {
        SystemUser entity = Optional.ofNullable(mapper.selectById(request.getId())).orElseThrow(() -> new LoongException("当前用户不存在"));
        entity.setState(request.getState());
        mapper.updateById(entity);
    }
}


package com.ronnaces.ronna.boot.system.modules.user.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.ronna.boot.system.modules.user.bean.request.AdjustStateRequest;
import com.ronnaces.ronna.boot.system.modules.user.bean.response.SystemUserResponse;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.mapper.SystemUserMapper;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @Override
    public List<String> findByDeptId(String deptId) {
        return mapper.findByDeptId(deptId);
    }

    @Override
    public List<SystemUserResponse> pageCustom(List<SystemUser> records) {
        return records.parallelStream().map(this::from).collect(Collectors.toList());
    }

    private SystemUserResponse from(SystemUser user) {
        SystemUserResponse response = new SystemUserResponse();
        BeanUtils.copyProperties(user, response);
        response.setRemark(user.getDescription());
        response.setStatus(user.getState());

        Map<String, Object> deptMap = mapper.findDeptById(user.getId());
        SystemUserResponse.Dept dept = JSON.parseObject(JSON.toJSONString(deptMap), SystemUserResponse.Dept.class);
        response.setDept(dept);
        return response;
    }
}


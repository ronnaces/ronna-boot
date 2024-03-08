package com.ronnaces.ronna.boot.system.modules.department.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;
import com.ronnaces.ronna.boot.system.modules.department.user.mapper.SystemDepartmentUserMapper;
import com.ronnaces.ronna.boot.system.modules.department.user.service.ISystemDepartmentUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SystemDepartmentUserServiceImpl extends ServiceImpl<SystemDepartmentUserMapper, SystemDepartmentUser> implements ISystemDepartmentUserService {

    private final SystemDepartmentUserMapper mapper;

}


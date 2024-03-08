package com.ronnaces.ronna.boot.system.modules.department.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;

import java.util.List;


public interface ISystemDepartmentUserService extends IService<SystemDepartmentUser> {

    List<String> findOfUserId(String userId);
}

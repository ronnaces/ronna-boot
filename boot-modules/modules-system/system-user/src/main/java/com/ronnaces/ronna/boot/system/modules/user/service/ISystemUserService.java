package com.ronnaces.ronna.boot.system.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;

import java.util.List;
import java.util.Map;

public interface ISystemUserService extends IService<SystemUser> {

    List<String> roles(String id);

    SystemUser find(String username);

    List<String> findByDeptId(String deptId);

    Map<String, Object> findDeptById(String deptId);

}

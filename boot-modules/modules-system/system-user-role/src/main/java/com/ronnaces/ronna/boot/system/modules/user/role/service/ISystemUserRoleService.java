package com.ronnaces.ronna.boot.system.modules.user.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.user.role.entity.SystemUserRole;

import java.util.List;


public interface ISystemUserRoleService extends IService<SystemUserRole> {

    List<String> findOfUserId(String userId);
}

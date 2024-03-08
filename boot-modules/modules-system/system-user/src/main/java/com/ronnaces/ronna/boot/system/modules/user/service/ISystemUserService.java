package com.ronnaces.ronna.boot.system.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;

import java.util.List;


public interface ISystemUserService extends IService<SystemUser> {

    List<String> roles(String id);

    SystemUser findByUsername(String userName);

}

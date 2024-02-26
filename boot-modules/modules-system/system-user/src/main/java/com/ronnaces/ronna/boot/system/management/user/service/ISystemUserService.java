package com.ronnaces.ronna.boot.system.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;

import java.util.List;

/**
 * ISystemUserService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-29
 */
public interface ISystemUserService extends IService<SystemUser> {

    List<String> roles(String id);

}

package com.ronnaces.ronna.boot.system.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.ronna.boot.system.modules.user.bean.request.AdjustStateRequest;
import com.ronnaces.ronna.boot.system.modules.user.bean.response.SystemUserResponse;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;

import java.util.List;


public interface ISystemUserService extends IService<SystemUser> {

    List<String> roles(String id);

    SystemUser find(String username);

    void adjustState(AdjustStateRequest request);

    List<String> findByDeptId(String deptId);

    List<SystemUserResponse> pageCustom(List<SystemUser> records);
}

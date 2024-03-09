package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.response.Department;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;

import java.util.List;


public interface IUserService {

    UserResponse info(String username);

    Boolean unique(SystemUser entity);

    List<Department> userDepartment();

    Boolean exist(String username);
}

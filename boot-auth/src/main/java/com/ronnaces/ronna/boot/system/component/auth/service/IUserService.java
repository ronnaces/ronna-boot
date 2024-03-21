package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;


public interface IUserService {

    UserResponse info(String username);

}

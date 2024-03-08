package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.ProfileRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.UserResponse;


public interface IProfileService {

    void edit(String name, ProfileRequest request);

    UserResponse detail(String name);

    void resetPassword(String name);
}

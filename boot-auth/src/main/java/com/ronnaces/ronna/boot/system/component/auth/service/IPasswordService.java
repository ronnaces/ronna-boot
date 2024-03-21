package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ResetPasswordRequest;


public interface IPasswordService {

    void changePassword(ChangePasswordRequest entity);

    void resetPassword(ResetPasswordRequest entity);
}

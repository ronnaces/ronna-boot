package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.*;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


public interface IAuthService {

    void register(RegisterRequest entity);

    LoginResponse login(LoginRequest entity, HttpServletRequest request);

//    LoginResponse loginPhone(LoginPhoneRequest entity, HttpServletRequest request);

    UserResponse userinfo(String username);

    Boolean checkUniqueness(SystemUser entity);

    void changePassword(ChangePasswordRequest entity);

    void resetPassword(String userId);

    List<PermissionResponse> roleRoutes(String roleId);

    RefreshTokenResponse refreshToken(String refreshToken);

    void bindRole(String id, List<String> roles);

    void bindPermission(String roleId, List<String> permissionIdList);

    void bindDepartment(String userId, List<String> departments);

    List<String> userPermission(String username);

    List<Router> userRouter(WebUser user);

    List<Department> userDepartment();

    Boolean userExist(String username);
}

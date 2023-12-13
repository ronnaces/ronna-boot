package com.ronnaces.ronna.boot.system.component.authentication.service;

import com.ronnaces.ronna.boot.system.component.authentication.bean.request.LoginPhoneRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.response.LoginResponse;
import com.ronnaces.ronna.boot.system.component.authentication.bean.response.RefreshTokenResponse;
import com.ronnaces.ronna.boot.system.component.authentication.bean.response.RouteResponse;
import com.ronnaces.ronna.boot.system.component.authentication.bean.response.UserResponse;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.permission.entity.SystemPermission;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * IAuthorizationService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
public interface IAuthenticationService {

    /**
     * register
     *
     * @param entity entity
     */
    void register(RegisterRequest entity);

    LoginResponse login(LoginRequest entity, HttpServletRequest request);

    LoginResponse loginPhone(LoginPhoneRequest entity, HttpServletRequest request);

    UserResponse userinfo(String username);

    Boolean checkUniqueness(SystemUser entity);

    void changePassword(SystemUser entity);

    void resetPassword(SystemUser entity);

    List<RouteResponse> userRoutes(String username);

    List<RouteResponse> treeRoutes();

    List<SystemPermission> roleRoutes(String roleId);

    RefreshTokenResponse refreshToken(String refreshToken);

    void bindRole(String id, List<String> roles);

    void bindPermission(String roleId, List<String> permissionIdList);

}

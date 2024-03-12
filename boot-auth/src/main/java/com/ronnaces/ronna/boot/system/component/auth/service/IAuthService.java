package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RefreshTokenRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.LoginResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.RefreshTokenResponse;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import jakarta.servlet.http.HttpServletRequest;


public interface IAuthService {

    void register(RegisterRequest entity);

    LoginResponse login(LoginRequest entity, HttpServletRequest request);

    WebUser auth(String username, String password);

    RefreshTokenResponse refreshToken(RefreshTokenRequest entity, HttpServletRequest request);
}

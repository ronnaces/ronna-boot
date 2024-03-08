package com.ronnaces.ronna.boot.system.component.auth.service;

import com.ronnaces.ronna.boot.system.component.auth.bean.response.PermissionResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.Router;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;

import java.util.List;


public interface IRouteService {

    List<PermissionResponse> roleRoute(String roleId);

    List<String> userPermission(String username);

    List<Router> userRoute(WebUser user);

}

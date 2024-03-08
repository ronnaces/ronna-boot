package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.PermissionResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.Router;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.component.auth.service.IRouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "路由管理")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/auth/route")
public class RouteController {

    private final IRouteService service;

    @Operation(summary = "查询用户权限列表")
    @GetMapping(value = "/user/permission")
    public Result<List<String>> userPermission(Authentication authentication) {
        WebUser user = (WebUser) authentication.getPrincipal();
        return Result.success(service.userPermission(user.getId()));
    }

    @Operation(summary = "查询角色路由列表")
    @GetMapping(value = "/role/route")
    public Result<List<PermissionResponse>> roleRoutes(@RequestParam("roleId") String roleId) {
        return Result.success(service.roleRoutes(roleId));
    }

    @Operation(summary = "查询用户路由列表")
    @GetMapping(value = "/user/route")
    public Result<List<Router>> userRoute(Authentication authentication) {
        return Result.success(service.userRoute((WebUser) authentication.getPrincipal()));
    }

}
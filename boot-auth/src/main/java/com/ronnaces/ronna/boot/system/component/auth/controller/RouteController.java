package com.ronnaces.ronna.boot.system.component.auth.controller;

import com.ronnaces.loong.common.entity.R;
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
@RequestMapping("/v1/route")
public class RouteController {

    private final IRouteService service;

    @Operation(summary = "查询用户权限列表")
    @GetMapping(value = "/user/permission")
    public R<List<String>> userPermission(Authentication authentication) {
        WebUser user = (WebUser) authentication.getPrincipal();
        return R.ok(service.userPermission(user.getId()));
    }

    @Operation(summary = "查询角色路由列表")
    @GetMapping(value = "/role/route")
    public R<List<PermissionResponse>> roleRoute(@RequestParam("roleId") String roleId) {
        return R.ok(service.roleRoute(roleId));
    }

    @Operation(summary = "查询用户路由列表")
    @GetMapping(value = "/user/route")
    public R<List<Router>> userRoute(Authentication authentication) {
        return R.ok(service.userRoute((WebUser) authentication.getPrincipal()));
    }

}
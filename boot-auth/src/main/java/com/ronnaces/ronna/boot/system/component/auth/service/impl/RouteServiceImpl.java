package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.ronnaces.loong.core.structure.tree.TreeUtils;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.Meta;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.PermissionResponse;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.Router;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.component.auth.service.IRouteService;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class RouteServiceImpl implements IRouteService {

    private final ISystemPermissionService permissionService;

    @Override
    public List<String> userPermission(String userId) {
        return permissionService.userPermission(userId).stream().map(SystemPermission::getCode).collect(Collectors.toList());
    }

    @Override
    public List<Router> userRoute(WebUser user) {
        List<SystemPermission> permissionList;
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        boolean isAdmin = false;
        for (GrantedAuthority authority : authorities) {
            if (StringUtils.equalsIgnoreCase("admin", authority.getAuthority())) {
                isAdmin = true;
                break;
            }
        }
        if (isAdmin) {
            permissionList = permissionService.list();
        } else {
            permissionList = permissionService.userPermission(user.getId());
        }
        if (CollectionUtils.isEmpty(permissionList)) {
            return Collections.singletonList(new Router());
        }
        List<Router> routerList = new ArrayList<>();
        permissionList.forEach(item -> {
            Router router = new Router();
            BeanUtils.copyProperties(item, router);
            Meta meta = Meta.builder().title(item.getTitle()).icon(item.getIcon()).rank(item.getRanking()).showParent(true).keepAlive(item.whetherRoot()).permission(item.getCode()).build();
            router.setMeta(meta);
            routerList.add(router);
        });
        return TreeUtils.buildTree(routerList);
    }

    @Override
    public List<PermissionResponse> roleRoute(String roleId) {
        return permissionService.findOfRoleId(roleId).stream().map(PermissionResponse::of).collect(Collectors.toList());
    }

}


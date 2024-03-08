package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import com.ronnaces.ronna.boot.system.modules.permission.service.ISystemPermissionService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ISystemUserService userService;

    private final ISystemDepartmentService departmentService;

    private final ISystemRoleService roleService;

    private final ISystemPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = Optional.ofNullable(userService.find(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        if (Boolean.TRUE.equals(user.getWhetherDelete())) {
            throw new AccessDeniedException(String.format("sorry, your account: %s have deleted", username));
        }

//        switch (UserState.match(user.getState())) {
//            case NORMAL:
//                break;
//            case LOCKED:
//                throw new AccessDeniedException(String.format("sorry, your account: %s have locked", username));
//            case DISABLED:
//                throw new AccessDeniedException(String.format("sorry, your account: %s have disabled", username));
//            default:
//                break;
//        }

        Set<String> roleList = roleService.findCodeByUserId(user.getId());
        if (roleList.isEmpty()) {
            throw new AccessDeniedException(String.format("sorry, your account: %s has no authorities and will be treated as not found", username));
        }

        Set<String> permissionList = new HashSet<>();
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (CollectionUtils.containsAny(roleList, "admin")) {
            permissionList.add("*:*:*");
        } else {
            permissionList = permissionService.findCodeByUserId(user.getId());
        }

        roleList.forEach(role -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        });

        WebUser webUser = new WebUser();
        webUser.setPermissionList(permissionList);
        webUser.setId(user.getId());
        webUser.setName(user.getName());
        webUser.setPassword(user.getPassword());
        webUser.setUsername(username);
        webUser.setAuthorities(authorities);
        webUser.setAccountNonExpired(true);
        webUser.setAccountNonLocked(true);
        webUser.setCredentialsNonExpired(true);
        webUser.setEnabled(true);
        return webUser;
    }
}

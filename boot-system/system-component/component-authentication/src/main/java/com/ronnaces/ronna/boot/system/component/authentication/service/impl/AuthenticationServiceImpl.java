package com.ronnaces.ronna.boot.system.component.authentication.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.LoginPhoneRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.authentication.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.authentication.config.AuthenticationProperties;
import com.ronnaces.ronna.boot.system.component.authentication.contanst.AuthenticationResponseStatusCodes;
import com.ronnaces.ronna.boot.system.component.authentication.enums.RouteType;
import com.ronnaces.ronna.boot.system.component.authentication.event.UserRegistrationEvent;
import com.ronnaces.ronna.boot.system.component.authentication.service.IAuthenticationService;
import com.ronnaces.ronna.boot.system.management.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.management.permission.mapper.SystemPermissionMapper;
import com.ronnaces.ronna.boot.system.management.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.management.role.mapper.SystemRoleMapper;
import com.ronnaces.ronna.boot.system.management.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.management.role.permission.mapper.SystemRolePermissionMapper;
import com.ronnaces.ronna.boot.system.management.role.permission.service.ISystemRolePermissionService;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.user.mapper.SystemUserMapper;
import com.ronnaces.ronna.boot.system.management.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.management.user.role.mapper.SystemUserRoleMapper;
import com.ronnaces.ronna.boot.system.management.user.role.service.ISystemUserRoleService;
import com.ronnaces.ronna.boot.system.component.authentication.bean.response.*;
import com.ronnaces.loong.common.exception.LoongStudioException;
import com.ronnaces.loong.core.constant.CommonConstant;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * AuthorizationServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final SystemUserMapper userMapper;

    private final SystemRoleMapper roleMapper;

    private final SystemRolePermissionMapper rolePermissionMapper;

    private final ISystemRolePermissionService rolePermissionService;

    private final SystemUserRoleMapper userRoleMapper;

    private final ISystemUserRoleService userRoleService;

    private final SystemPermissionMapper permissionMapper;

    private final PasswordEncoder encoder;

    private final ApplicationEventPublisher eventPublisher;

    private final AuthenticationProperties authenticationProperties;

    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest entity, HttpServletRequest request) {
        SystemUser user = Optional.of(userMapper.findByUsername(entity.getUsername())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        entity.getUsername(),
                        entity.getPassword()
                )
        );
        return responseLoginResult(user, request);
    }

    @Override
    public LoginResponse loginPhone(LoginPhoneRequest entity, HttpServletRequest request) {
        SystemUser user = Optional.of(userMapper.findByPhone(entity.getPhone())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        verifySmsCode(entity.getSmsCode());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        return responseLoginResult(user, request);
    }

    private LoginResponse responseLoginResult(SystemUser user, HttpServletRequest request) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);

        Map<String, Object> claim = new HashMap<>();
        claim.put("userinfo", JSON.toJSON(userResponse));
        List<String> roles = userMapper.findAllRoleCodeById(user.getId());

        String accessToken = JJWTUtil.generate(request.getRemoteHost(), user.getUsername(), authenticationProperties.getAccessTokenExpire(), claim);
        String refreshToken = JJWTUtil.generate(request.getRemoteHost(), user.getUsername(), authenticationProperties.getRefreshTokenExpire(), claim);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setExpires(LocalDateTime.now().plus(authenticationProperties.getAccessTokenExpire(), ChronoUnit.MILLIS));
        loginResponse.setUsername(user.getUsername());
        loginResponse.setRoles(roles);
        loginResponse.setAccessToken(accessToken);
        loginResponse.setRefreshToken(refreshToken);

        return loginResponse;
    }

    private void verifySmsCode(String smsCode) {
        if (StringUtils.isEmpty(smsCode)) {
            throw new LoongStudioException(AuthenticationResponseStatusCodes.SMS_CODE_IS_NULL);
        }

        // TODO 线上环境替换正式校验算法
        if (!StringUtils.equals("888888", smsCode)) {
            throw new LoongStudioException(AuthenticationResponseStatusCodes.SMS_CODE_VERIFY_FAILURE);
        }
    }

    @Override
    public void register(RegisterRequest entity) {
        SystemUser user = userMapper.findByUsername(entity.getUsername());
        if (Objects.nonNull(user)) {
            throw new LoongStudioException(AuthenticationResponseStatusCodes.USER_ALREADY_EXISTS);
        }
        verifySmsCode(entity.getSmsCode());
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(entity.getUsername());
        systemUser.setPhone(entity.getPhone());
        systemUser.setPassword(encoder.encode(entity.getPassword()));
        userMapper.insert(systemUser);
        eventPublisher.publishEvent(new UserRegistrationEvent(entity));
    }

    @Override
    public UserResponse userinfo(String username) {
        SystemUser systemUser = userMapper.findByUsername(username);
        if (Objects.isNull(systemUser)) {
            return null;
        }
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(systemUser, userResponse);

        List<String> roles = userMapper.findAllRoleCodeById(systemUser.getId());
        if (CollectionUtils.isNotEmpty(roles)) {
            userResponse.setRoles(roles);
        }

        return userResponse;
    }

    @Override
    public Boolean checkUniqueness(SystemUser entity) {
        SystemUser user = userMapper.selectOne(new QueryWrapper<>(entity));
        if (Objects.isNull(user)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public void changePassword(SystemUser entity) {

    }

    @Override
    public void resetPassword(SystemUser entity) {
        String defaultPassword = authenticationProperties.getDefaultPassword();
        entity.setPassword(encoder.encode(defaultPassword));
        userMapper.updateById(entity);
    }

    @Override
    public List<RouteResponse> userRoutes(String username) {
        return handleRoutes(permissionMapper.queryUserPermission(username));
    }

    @Override
    public List<RouteResponse> treeRoutes() {
        return handleRoutes(permissionMapper.selectList(null));
    }

    @Override
    public List<SystemPermission> roleRoutes(String roleId) {
        return permissionMapper.queryRolePermission(roleId);
    }

    private List<RouteResponse> handleRoutes(List<SystemPermission> permissionList) {
        if (CollectionUtils.isEmpty(permissionList)) {
            return Collections.singletonList(new RouteResponse());
        }

        List<RouteResponse> routeResponseList = new ArrayList<>();
        this.generateRouteList(routeResponseList, permissionList, null);
        this.handleFirstLevelMenuHidden(routeResponseList);

        return routeResponseList;
    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshToken) {
        String username = JJWTUtil.getSubject(refreshToken);
        SystemUser systemUser = Optional.of(userMapper.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
//        String tenant;
//        try {
//            tenant = Optional.of(tenantMapper.findCodeByUsername(username)).orElseThrow(() -> new AccessDeniedException("当前租户不存在"));
//        } catch (AccessDeniedException e) {
//            throw new RuntimeException(e);
//        }

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(systemUser, userResponse);

        Map<String, Object> claim = new HashMap<>();
        claim.put("userinfo", JSON.toJSON(userResponse));

        List<String> roles = userMapper.findAllRoleCodeById(systemUser.getId());
        userResponse.setRoles(roles);

        long expire = 2 * 60 * 60 * 1000L;
        String accessToken = JJWTUtil.generate("", username, expire, claim);

        RefreshTokenResponse token = new RefreshTokenResponse();
        token.setExpires(LocalDateTime.now().plus(expire, ChronoUnit.MILLIS));
        token.setAccessToken(accessToken);
        token.setRefreshToken(accessToken);
        return token;
    }

    @Override
    public void bindRole(String id, List<String> roles) {
        List<String> relationshipId = userRoleMapper.selectUserRoleRelationshipId(id, null);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            userRoleService.removeBatchByIds(relationshipId);
        }

        if (CollectionUtils.isNotEmpty(roles)) {
            List<SystemRole> roleList = roleMapper.findByRoles(roles);
            if (CollectionUtils.isNotEmpty(roleList)) {
                List<SystemUserRole> userRoleList = new ArrayList<>();
                roleList.forEach(role -> {
                    SystemUserRole userRole = new SystemUserRole();
                    userRole.setUserId(id);
                    userRole.setRoleId(role.getId());
                    userRoleList.add(userRole);
                });
                userRoleService.saveBatch(userRoleList);
            }
        }
    }

    @Override
    public void bindPermission(String id, List<String> permissionIdList) {
        List<String> relationshipId = rolePermissionMapper.selectRolePermissionRelationshipId(id, null);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            rolePermissionService.removeBatchByIds(relationshipId);
        }

        if (CollectionUtils.isNotEmpty(permissionIdList)) {
            List<SystemRolePermission> rolePermissionList = new ArrayList<>();
            permissionIdList.stream().distinct().forEach(permissionId -> {
                SystemRolePermission rolePermission = new SystemRolePermission();
                rolePermission.setRoleId(id);
                rolePermission.setPermissionId(permissionId);
                rolePermissionList.add(rolePermission);
            });
            rolePermissionService.saveBatch(rolePermissionList);
        }
    }

    /**
     * 获取菜单JSON数组
     *
     * @param routeResponseList   routeList
     * @param metaList            metaList
     * @param parentRouteResponse parentRoute
     */
    private void generateRouteList(List<RouteResponse> routeResponseList, List<SystemPermission> metaList, RouteResponse parentRouteResponse) {
        for (SystemPermission permission : metaList) {
            if (permission.getType() == null) {
                continue;
            }

            RouteResponse routeResponse = generateRoute(permission);
            String parentId = permission.getParentId();
            if (parentRouteResponse == null && StringUtils.isEmpty(parentId)) {
                routeResponseList.add(routeResponse);
                if (!permission.getWhetherLeaf()) {
                    generateRouteList(routeResponseList, metaList, routeResponse);
                }
            } else if (parentRouteResponse != null && StringUtils.isNotEmpty(parentId) && parentId.equals(parentRouteResponse.getId())) {
                if (CollectionUtils.isEmpty(parentRouteResponse.getChildren())) {
                    List<RouteResponse> children = new ArrayList<>();
                    children.add(routeResponse);
                    parentRouteResponse.setChildren(children);
                } else {
                    parentRouteResponse.getChildren().add(routeResponse);
                }

                if (!permission.getWhetherLeaf()) {
                    generateRouteList(routeResponseList, metaList, routeResponse);
                }
            }

        }
    }

    /**
     * 根据菜单配置生成路由
     *
     * @param permission 菜单
     * @return 路由
     */
    private RouteResponse generateRoute(SystemPermission permission) {
        RouteResponse routeResponse = new RouteResponse();
        MetaResponse metaResponse = new MetaResponse();

        switch (RouteType.match(permission.getType())) {
            case TOP:
//                route.setPath(permission.getPath());
                if (StringUtils.isNotEmpty(permission.getRedirect())) {
                    routeResponse.setRedirect(permission.getRedirect());
                }
                metaResponse.setAlwaysShow(true);
                break;
            case FIRST:
//                route.setPath(StringUtils.substringAfterLast(permission.getPath(), CommonConstant.SLASH));
                metaResponse.setAlwaysShow(false);
                break;
            default:
                break;
        }

        metaResponse.setShowLink(!permission.getWhetherHide());
        metaResponse.setRoles(Collections.singletonList("admin"));
        metaResponse.setTitle(permission.getTitle());
        metaResponse.setCode(permission.getId());
        metaResponse.setRank(permission.getRanking());
        if (StringUtils.isNotEmpty(permission.getIcon())) {
            metaResponse.setIcon(permission.getIcon());
        }
        if (StringUtils.isNotEmpty(permission.getIframeUrl())) {
            metaResponse.setFrameSrc(permission.getIframeUrl());
        }
        routeResponse.setPath(permission.getPath());
        routeResponse.setId(permission.getId());
//        route.setName(urlToRouteName(permission.getPath()));
        routeResponse.setName(permission.getName());
        routeResponse.setComponent(permission.getComponent());
        routeResponse.setMetaResponse(metaResponse);
        return routeResponse;
    }

    /**
     * 通过URL生成路由name（去掉URL前缀斜杠，替换内容中的斜杠‘/’为-） 举例： URL = /system/role => RouteName = system-role
     *
     * @return route name
     */
    private String urlToRouteName(String url) {
        if (StringUtils.isNotEmpty(url)) {
            if (url.startsWith(CommonConstant.SLASH)) {
                url = url.substring(1);
            }
            url = url.replace("/", "-");
            url = url.replace(":", "@");
            return url;
        } else {
            return null;
        }
    }


    /**
     * 一级菜单的子菜单全部是隐藏路由，则一级菜单不显示
     *
     * @param routeResponseList
     */
    private void handleFirstLevelMenuHidden(List<RouteResponse> routeResponseList) {
        routeResponseList = routeResponseList.stream()
                .peek(routeResponse -> {
                    List<RouteResponse> routeResponseChildren = routeResponse.getChildren();
                    if (CollectionUtils.isNotEmpty(routeResponseChildren)) {
                        List<RouteResponse> hiddenRouteResponse = routeResponseChildren.stream().filter(child -> !child.getMetaResponse().getShowLink()).collect(Collectors.toList());
                        if (CollectionUtils.isEmpty(hiddenRouteResponse)) {
                            MetaResponse metaResponse = routeResponse.getMetaResponse();
                            metaResponse.setShowLink(true);
                            routeResponse.setMetaResponse(metaResponse);
                        }
                    }
                }).collect(Collectors.toList());
    }
}


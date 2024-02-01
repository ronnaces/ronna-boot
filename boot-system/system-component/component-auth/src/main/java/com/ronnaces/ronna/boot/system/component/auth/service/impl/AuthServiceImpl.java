package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ronnaces.loong.common.exception.LoongStudioException;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import com.ronnaces.loong.core.structure.tree.TreeUtils;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginPhoneRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.*;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.contanst.AuthResponseStatusCodes;
import com.ronnaces.ronna.boot.system.component.auth.event.UserRegistrationEvent;
import com.ronnaces.ronna.boot.system.component.auth.service.IAuthService;
import com.ronnaces.ronna.boot.system.management.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.management.department.mapper.SystemDepartmentMapper;
import com.ronnaces.ronna.boot.system.management.department.user.entity.SystemDepartmentUser;
import com.ronnaces.ronna.boot.system.management.department.user.mapper.SystemDepartmentUserMapper;
import com.ronnaces.ronna.boot.system.management.department.user.service.ISystemDepartmentUserService;
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
public class AuthServiceImpl implements IAuthService {

    private final SystemUserMapper userMapper;

    private final SystemRoleMapper roleMapper;

    private final SystemRolePermissionMapper rolePermissionMapper;

    private final ISystemRolePermissionService rolePermissionService;

    private final SystemUserRoleMapper userRoleMapper;

    private final ISystemUserRoleService userRoleService;

    private final SystemPermissionMapper permissionMapper;

    private final SystemDepartmentMapper departmentMapper;

    private final SystemDepartmentUserMapper departmentUserMapper;

    private final ISystemDepartmentUserService departmentUserService;

    private final PasswordEncoder encoder;

    private final ApplicationEventPublisher eventPublisher;

    private final AuthProperties authProperties;

    private final AuthenticationManager authenticationManager;

    private static UserResponse toPojo(SystemUser user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        userResponse.setRealName(user.getName());
        userResponse.setUserId(user.getId());
        userResponse.setDesc(user.getDescription());
        return userResponse;
    }

    @Override
    public LoginResponse login(LoginRequest entity, HttpServletRequest request) {
        SystemUser user = Optional.ofNullable(userMapper.findByUsername(entity.getUsername())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        auth(entity.getUsername(), entity.getPassword());
        return responseLoginResult(user, request);
    }

    private void auth(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
    }

    @Override
    public LoginResponse loginPhone(LoginPhoneRequest entity, HttpServletRequest request) {
        SystemUser user = Optional.ofNullable(userMapper.findByPhone(entity.getPhone())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
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
        UserResponse userResponse = toPojo(user);

        Map<String, Object> claim = new HashMap<>();
        claim.put("userinfo", JSON.toJSON(userResponse));
        List<LoginRoleResponse> roleList = roleMapper.findByUserId(user.getId()).stream().map(r -> new LoginRoleResponse(r.getCode(), r.getName())).toList();
        String accessToken = JJWTUtil.generate(request.getRemoteHost(), user.getUsername(), authProperties.getAccessTokenExpire(), claim);
        String refreshToken = JJWTUtil.generate(request.getRemoteHost(), user.getUsername(), authProperties.getRefreshTokenExpire(), claim);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoles(roleList);
        loginResponse.setToken(accessToken);
//        loginResponse.setExpires(LocalDateTime.now().plus(authenticationProperties.getAccessTokenExpire(), ChronoUnit.MILLIS));
//        loginResponse.setAccessToken(accessToken);
//        loginResponse.setRefreshToken(refreshToken);
        return loginResponse;
    }

    private void verifySmsCode(String smsCode) {
        if (StringUtils.isEmpty(smsCode)) {
            throw new LoongStudioException(AuthResponseStatusCodes.SMS_CODE_IS_NULL);
        }

        // TODO 线上环境替换正式校验算法
        if (!StringUtils.equals("888888", smsCode)) {
            throw new LoongStudioException(AuthResponseStatusCodes.SMS_CODE_VERIFY_FAILURE);
        }
    }

    @Override
    public void register(RegisterRequest entity) {
        SystemUser user = userMapper.findByUsername(entity.getUsername());
        if (Objects.nonNull(user)) {
            throw new LoongStudioException(AuthResponseStatusCodes.USER_ALREADY_EXISTS);
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
        SystemUser user = Optional.ofNullable(userMapper.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        UserResponse userResponse = toPojo(user);

        List<LoginRoleResponse> roleList = roleMapper.findByUserId(user.getId()).stream().map(r -> new LoginRoleResponse(r.getCode(), r.getName())).toList();
        if (CollectionUtils.isNotEmpty(roleList)) {
            userResponse.setRoles(roleList);
        }

        return userResponse;
    }

    @Override
    public List<String> userPermission(String username) {
        return permissionMapper.queryUserPermission(username).stream().map(SystemPermission::getCode).collect(Collectors.toList());
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
    public void changePassword(ChangePasswordRequest entity) {
        SystemUser user = Optional.ofNullable(userMapper.findByUsername(entity.getUsername())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        if (!encoder.matches(entity.getOldPassword(), user.getPassword())) {
            throw new UsernameNotFoundException("输入的用户名或密码不正确");
        }

        user.setPassword(encoder.encode(entity.getPassword()));
        userMapper.updateById(user);
        auth(entity.getUsername(), entity.getPassword());
    }

    @Override
    public void resetPassword(String userId) {
        SystemUser user = Optional.ofNullable(userMapper.selectById(userId)).orElseThrow(() -> new LoongStudioException("当前用户不存在"));
        String defaultPassword = authProperties.getDefaultPassword();
        user.setPassword(encoder.encode(defaultPassword));
        userMapper.updateById(user);
    }

    @Override
    public List<Router> userRouter(String username) {
        List<SystemPermission> permissionList = permissionMapper.queryUserPermission(username);
        if (CollectionUtils.isEmpty(permissionList)) {
            return Collections.singletonList(new Router());
        }

        List<Router> routerList = new ArrayList<>();
        permissionList.forEach(item -> {
            Router router = new Router();
            BeanUtils.copyProperties(item, router);
            Meta meta = Meta.builder()
                    .title(item.getTitle()).icon(item.getIcon()).build();
            if (!item.whetherRoot()) {
                meta.setIgnoreKeepAlive(true);
            }
            router.setMeta(meta);
            routerList.add(router);
        });
        return TreeUtils.buildTree(routerList);
    }

    @Override
    public List<Department> userDepartment() {
        List<SystemDepartment> departmentList = departmentMapper.selectList(null);
        if (CollectionUtils.isEmpty(departmentList)) {
            return Collections.singletonList(new Department());
        }

        List<Department> routerList = new ArrayList<>();
        departmentList.forEach(item -> {
            Department department = new Department();
            BeanUtils.copyProperties(item, department);
            routerList.add(department);
        });
        return TreeUtils.buildTree(routerList);
    }

    @Override
    public Boolean userExist(String username) {
        return Objects.nonNull(userMapper.findByUsername(username));
    }

    @Override
    public List<SystemPermission> roleRoutes(String roleId) {
        return permissionMapper.queryRolePermission(roleId);
    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshToken) {
        String username = JJWTUtil.getSubject(refreshToken);
        SystemUser user = Optional.ofNullable(userMapper.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
//        String tenant;
//        try {
//            tenant = Optional.ofNullable(tenantMapper.findCodeByUsername(username)).orElseThrow(() -> new AccessDeniedException("当前租户不存在"));
//        } catch (AccessDeniedException e) {
//            throw new RuntimeException(e);
//        }

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);

        Map<String, Object> claim = new HashMap<>();
        claim.put("userinfo", JSON.toJSON(userResponse));

        List<LoginRoleResponse> roleList = roleMapper.findByUserId(user.getId()).stream().map(r -> new LoginRoleResponse(r.getCode(), r.getName())).toList();
        userResponse.setRoles(roleList);

        long expire = 2 * 60 * 60 * 1000L;
        String accessToken = JJWTUtil.generate("", username, expire, claim);

        RefreshTokenResponse token = new RefreshTokenResponse();
        token.setExpires(LocalDateTime.now().plus(expire, ChronoUnit.MILLIS));
        token.setAccessToken(accessToken);
        token.setRefreshToken(accessToken);
        return token;
    }

    @Override
    public void bindRole(String id, List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<String> relationshipId = userRoleMapper.selectRelationshipId(id, null);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            userRoleService.removeBatchByIds(relationshipId);
        }
        List<SystemRole> daoList = roleMapper.findByIds(list);
        if (CollectionUtils.isEmpty(daoList)) {
            return;
        }
        List<SystemUserRole> saveList = new ArrayList<>();
        daoList.stream().distinct().forEach(dao -> {
            SystemUserRole entity = new SystemUserRole();
            entity.setUserId(id);
            entity.setRoleId(dao.getId());
            saveList.add(entity);
        });
        userRoleService.saveBatch(saveList);
    }

    @Override
    public void bindPermission(String id, List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<String> relationshipId = rolePermissionMapper.selectRelationshipId(id, null);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            rolePermissionService.removeBatchByIds(relationshipId);
        }
        List<SystemPermission> daoList = permissionMapper.findByIds(list);
        if (CollectionUtils.isEmpty(daoList)) {
            return;
        }
        List<SystemRolePermission> saveList = new ArrayList<>();
        daoList.stream().distinct().forEach(dao -> {
            SystemRolePermission entity = new SystemRolePermission();
            entity.setRoleId(id);
            entity.setPermissionId(dao.getId());
            saveList.add(entity);
        });
        rolePermissionService.saveBatch(saveList);
    }

    @Override
    public void bindDepartment(String id, List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<String> relationshipId = departmentUserMapper.selectRelationshipId(id, null);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            departmentUserService.removeBatchByIds(relationshipId);
        }
        List<SystemDepartment> daoList = departmentMapper.findByIds(list);
        if (CollectionUtils.isEmpty(daoList)) {
            return;
        }
        List<SystemDepartmentUser> saveList = new ArrayList<>();
        daoList.stream().distinct().forEach(dao -> {
            SystemDepartmentUser entity = new SystemDepartmentUser();
            entity.setUserId(id);
            entity.setDepartmentId(dao.getId());
            saveList.add(entity);
        });
        departmentUserService.saveBatch(saveList);
    }
}


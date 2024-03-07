package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.loong.core.jwt.JJWTUtil;
import com.ronnaces.loong.core.structure.tree.TreeUtils;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.ChangePasswordRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.LoginRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.request.RegisterRequest;
import com.ronnaces.ronna.boot.system.component.auth.bean.response.*;
import com.ronnaces.ronna.boot.system.component.auth.config.AuthProperties;
import com.ronnaces.ronna.boot.system.component.auth.contanst.AuthResponseStatusCodes;
import com.ronnaces.ronna.boot.system.component.auth.event.UserRegistrationEvent;
import com.ronnaces.ronna.boot.system.component.auth.model.WebUser;
import com.ronnaces.ronna.boot.system.component.auth.service.IAuthService;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.modules.department.mapper.SystemDepartmentMapper;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;
import com.ronnaces.ronna.boot.system.modules.department.user.mapper.SystemDepartmentUserMapper;
import com.ronnaces.ronna.boot.system.modules.department.user.service.ISystemDepartmentUserService;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import com.ronnaces.ronna.boot.system.modules.permission.mapper.SystemPermissionMapper;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import com.ronnaces.ronna.boot.system.modules.role.mapper.SystemRoleMapper;
import com.ronnaces.ronna.boot.system.modules.role.permission.entity.SystemRolePermission;
import com.ronnaces.ronna.boot.system.modules.role.permission.mapper.SystemRolePermissionMapper;
import com.ronnaces.ronna.boot.system.modules.role.permission.service.ISystemRolePermissionService;
import com.ronnaces.ronna.boot.system.modules.role.service.ISystemRoleService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.mapper.SystemUserMapper;
import com.ronnaces.ronna.boot.system.modules.user.role.entity.SystemUserRole;
import com.ronnaces.ronna.boot.system.modules.user.role.mapper.SystemUserRoleMapper;
import com.ronnaces.ronna.boot.system.modules.user.role.service.ISystemUserRoleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final ISystemRoleService roleService;

    private final SystemPermissionMapper permissionMapper;

    private final SystemDepartmentMapper departmentMapper;

    private final SystemDepartmentUserMapper departmentUserMapper;

    private final ISystemDepartmentUserService departmentUserService;

    private final PasswordEncoder encoder;

    private final ApplicationEventPublisher eventPublisher;

    private final AuthProperties authProperties;

    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest entity, HttpServletRequest request) {
        return login(auth(entity.getUsername(), entity.getPassword()), request);
    }

    private WebUser auth(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return (WebUser) authenticate.getPrincipal();
    }

/*    @Override
    public LoginResponse loginPhone(LoginPhoneRequest entity, HttpServletRequest request) {
        verifySmsCode(entity.getSmsCode());
        SystemUser user = Optional.ofNullable(userMapper.findByPhone(entity.getPhone())).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        return createToken(entity.getPhone(), request);
    }*/

    private LoginResponse login(WebUser auth, HttpServletRequest request) {
        UserResponse userResponse = new UserResponse();
        userResponse.setRoles(userResponse.toRole(auth.getAuthorities()));
        userResponse.setPermissions(auth.getPermissionList());
        userResponse.setUserId(auth.getUserId());
        userResponse.setUsername(auth.getUsername());
        userResponse.setName(auth.getUsername());
        userResponse.setAvatar(auth.getAvatar());

        Map<String, Object> claim = new HashMap<>();
        claim.put("user", JSON.toJSON(auth));
        String accessToken = JJWTUtil.generate(request.getRemoteHost(), userResponse.getUsername(), authProperties.getAccessTokenExpire(), claim);
        String refreshToken = JJWTUtil.generate(request.getRemoteHost(), userResponse.getUsername(), authProperties.getRefreshTokenExpire(), claim);

        LoginResponse response = new LoginResponse();
        response.setUser(userResponse);
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        return response;
    }

    private void verifySmsCode(String smsCode) {
        if (StringUtils.isEmpty(smsCode)) {
            throw new LoongException(AuthResponseStatusCodes.SMS_CODE_IS_NULL);
        }

        // TODO 线上环境替换正式校验算法
        if (!StringUtils.equals("888888", smsCode)) {
            throw new LoongException(AuthResponseStatusCodes.SMS_CODE_VERIFY_FAILURE);
        }
    }

    @Override
    public void register(RegisterRequest entity) {
        SystemUser user = userMapper.findByUsername(entity.getUsername());
        if (Objects.nonNull(user)) {
            throw new LoongException(AuthResponseStatusCodes.USER_ALREADY_EXISTS);
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
        UserResponse userResponse = UserResponse.of(user);

//        List<RoleResponse> roleList = roleMapper.findByUserId(user.getId()).stream().map(r -> new RoleResponse(r.getCode(), r.getName())).toList();
        Set<String> roleList = roleService.findCodeByUserId(user.getId());
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
        SystemUser user = Optional.ofNullable(userMapper.selectById(userId)).orElseThrow(() -> new LoongException("当前用户不存在"));
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
    public List<PermissionResponse> roleRoutes(String roleId) {
        return permissionMapper.queryRolePermission(roleId).stream().map(PermissionResponse::of).collect(Collectors.toList());
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

//        List<RoleResponse> roleList = roleMapper.findByUserId(user.getId()).stream().map(r -> new RoleResponse(r.getCode(), r.getName())).toList();
        Set<String> roleList = roleService.findCodeByUserId(user.getId());
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


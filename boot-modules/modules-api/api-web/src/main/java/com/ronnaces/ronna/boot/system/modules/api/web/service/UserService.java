package com.ronnaces.ronna.boot.system.modules.api.web.service;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ronnaces.loong.common.controller.q.CommonQService;
import com.ronnaces.loong.common.entity.PageQEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.entity.Query;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.CreateUserRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditUserRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditUserStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.SystemUserRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.SystemUserResponse;
import com.ronnaces.ronna.boot.system.modules.api.web.config.UploadFileProperties;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;
import com.ronnaces.ronna.boot.system.modules.department.user.service.ISystemDepartmentUserService;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator.getInstance;


@Slf4j
@AllArgsConstructor
@Service
public class UserService implements CommonQService<SystemUser, SystemUserRequest> {

    private final ISystemUserService userService;

    private final PasswordEncoder encoder;

    private final UploadFileProperties fileProperties;

    private final ISystemDepartmentUserService departmentUserService;

    public boolean create(CreateUserRequest payload) {
        SystemUser user = CreateUserRequest.to(payload);
        user.setPassword(encoder.encode(payload.getPassword()));
        boolean result = userService.save(user);
        SystemUser systemUser = userService.find(payload.getUsername());

        String parentId = payload.getParentId();
        if (StringUtils.isNotEmpty(parentId)) {
            SystemDepartmentUser departmentUser = new SystemDepartmentUser();
            departmentUser.setUserId(systemUser.getId());
            departmentUser.setDepartmentId(parentId);
            departmentUserService.save(departmentUser);
        }
        return result;
    }

    public boolean edit(EditUserRequest payload) {
        SystemUser user = EditUserRequest.to(payload, userService.getById(payload.getId()));
        boolean result = userService.updateById(user);

        String parentId = payload.getParentId();
        if (StringUtils.isNotEmpty(parentId)) {
            unbindDepartment(payload.getId(), Collections.singletonList(payload.getParentId()));

            SystemDepartmentUser departmentUser = new SystemDepartmentUser();
            departmentUser.setUserId(payload.getId());
            departmentUser.setDepartmentId(parentId);
            departmentUserService.save(departmentUser);
        }
        return result;
    }

    private void unbindDepartment(String mainId, List<String> minorIds) {
        if (CollectionUtils.isEmpty(minorIds)) {
            return;
        }
        List<String> relationshipId = departmentUserService.findOfUserId(mainId);
        if (CollectionUtils.isNotEmpty(relationshipId)) {
            departmentUserService.removeBatchByIds(relationshipId);
        }
    }

    public void editState(EditUserStateRequest request) {
        SystemUser entity = Optional.ofNullable(userService.getById(request.getId())).orElseThrow(() -> new LoongException("当前用户不存在"));
        entity.setState(request.getStatus());
        userService.updateById(entity);
    }

    private List<SystemUserResponse> pageCustom(List<SystemUser> records) {
        return records.stream().map(this::from).collect(Collectors.toList());
    }

    private SystemUserResponse from(SystemUser user) {
        SystemUserResponse response = new SystemUserResponse();
        BeanUtils.copyProperties(user, response);
        response.setRemark(user.getDescription());
        response.setStatus(user.getState());

        Map<String, Object> deptMap = userService.findDeptById(user.getId());
        SystemUserResponse.Dept dept = JSON.parseObject(JSON.toJSONString(deptMap), SystemUserResponse.Dept.class);
        response.setDept(dept);
        return response;
    }

    public PageResult<SystemUserResponse> page(PageQEntity<SystemUserRequest> entity) {
        String deptId = entity.getJoinQuery().getDeptId();
        List<String> userIdList = userService.findByDeptId(deptId);
        if (StringUtils.isNoneBlank(deptId) && CollectionUtils.isEmpty(userIdList)) {
            return new PageResult<>();
        }

        List<Query> queryList = entity.getQueryList();
        Query query = Query.builder().fieldName("id").fieldValue(userIdList).nested(SqlKeyword.AND.getSqlSegment()).operator(SqlKeyword.IN.getSqlSegment()).build();
        queryList.add(query);
        entity.setQueryList(queryList);
        PageResult<SystemUser> pageResult = of(userService.page(new Page<>(entity.getPage(), entity.getPageSize()), createQueryWrapper(entity)));
        List<SystemUserResponse> systemUserResponses = pageCustom(pageResult.getRecords());

        PageResult<SystemUserResponse> result = new PageResult<>();
        result.setTotal(pageResult.getTotal());
        result.setCurrent(pageResult.getCurrent());
        result.setSize(pageResult.getSize());
        result.setRecords(systemUserResponses);
        return result;
    }

    public List<String> roles(String id) {
        return userService.roles(id);
    }

    public void avatar(MultipartFile file, String id, HttpServletRequest request) {
        if (Objects.isNull(file)) {
            return;
        }

        LocalDate now = LocalDate.now();
        Long nextId = getInstance().nextId(null);
        String storageFile = now.format(DateTimeFormatter.BASIC_ISO_DATE) + "/" + nextId + "." + "jpg";
        Path path = Paths.get(fileProperties.getData(), "/images/", storageFile);
        path.toFile().getParentFile().mkdirs();

        try {
            file.transferTo(path);
        } catch (IOException e) {
            log.error("storage file error.", e);
            return;
        }

//        File savedFile = path.toFile();
//        if (!savedFile.exists()) {
//            throw new LoongException("storage file error.");
//        }

        String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/images/" + storageFile;
        SystemUser user = userService.getById(id);
        user.setAvatar(filePath);
        userService.updateById(user);
    }
}


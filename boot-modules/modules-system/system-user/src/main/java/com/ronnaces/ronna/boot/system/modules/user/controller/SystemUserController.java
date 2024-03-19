package com.ronnaces.ronna.boot.system.modules.user.controller;

import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ronnaces.loong.common.controller.q.CrudQExcelController;
import com.ronnaces.loong.common.entity.PageQEntity;
import com.ronnaces.loong.common.entity.PageResult;
import com.ronnaces.loong.common.entity.Query;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.system.modules.user.bean.request.AdjustStateRequest;
import com.ronnaces.ronna.boot.system.modules.user.bean.request.SystemUserRequest;
import com.ronnaces.ronna.boot.system.modules.user.bean.response.SystemUserResponse;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.service.ISystemUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "用户表")
@Getter
@Slf4j
@AccessLogger
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/system/user")
public class SystemUserController implements CrudQExcelController<SystemUser, SystemUserRequest> {

    private final ISystemUserService service;

    @Operation(summary = "查询角色列表")
    @GetMapping(value = "/roles/{id:.+}")
    public R<List<String>> roles(@Parameter(name = "id", required = true) @PathVariable(name = "id") String id) {
        return R.ok(service.roles(id));
    }

    @Operation(summary = "调整状态")
    @PutMapping(value = "/adjust/state/{id:.+}")
    public R<?> adjustState(@RequestBody AdjustStateRequest request) {
        service.adjustState(request);
        return R.ok();
    }

    @Operation(summary = "分页列表")
    @PostMapping("/page/custom")
    public R<PageResult<SystemUserResponse>> pageCustom(@RequestBody PageQEntity<SystemUserRequest> entity) {
        SystemUserRequest joinQuery = entity.getJoinQuery();
        String deptId = joinQuery.getDeptId();
        List<String> userIdList = service.findByDeptId(deptId);
        List<Query> queryList = entity.getQueryList();
        Query query = Query.builder().fieldName("id").fieldValue(userIdList).nested(SqlKeyword.AND.getSqlSegment()).operator(SqlKeyword.IN.getSqlSegment()).build();
        queryList.add(query);
        entity.setQueryList(queryList);
        PageResult<SystemUser> pageResult = of(getService().page(new Page<>(entity.getPage(), entity.getPageSize()), createQueryWrapper(entity)));
        List<SystemUserResponse> systemUserResponses = service.pageCustom(pageResult.getRecords());

        PageResult<SystemUserResponse> result = new PageResult<>();
        result.setTotal(pageResult.getTotal());
        result.setCurrent(pageResult.getCurrent());
        result.setSize(pageResult.getSize());
        result.setRecords(systemUserResponses);
        return R.ok(result);
    }
}
package com.ronnaces.ronna.boot.system.modules.api.web.service;

import com.ronnaces.loong.common.controller.CommonService;
import com.ronnaces.loong.common.entity.ListEntity;
import com.ronnaces.loong.common.exception.LoongException;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.EditStateRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.dept.CreateDeptRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.request.dept.EditDeptRequest;
import com.ronnaces.ronna.boot.system.modules.api.web.bean.response.dept.DeptResponse;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class DeptService implements CommonService<SystemDepartment> {

    private final ISystemDepartmentService service;

    public boolean create(CreateDeptRequest payload) {
        return service.save(CreateDeptRequest.to(payload));
    }

    public boolean edit(EditDeptRequest payload) {
        return service.updateById(EditDeptRequest.to(payload, service.getById(payload.getId())));
    }

    public void editState(EditStateRequest request) {
        SystemDepartment entity = Optional.ofNullable(service.getById(request.getId())).orElseThrow(() -> new LoongException("当前用户不存在"));
        entity.setWhetherForbid(request.getStatus());
        service.updateById(entity);
    }

    public List<DeptResponse> list(ListEntity entity) {
        return service.list(this.createQueryWrapper(entity)).stream().map(DeptResponse::of).collect(Collectors.toList());
    }
}
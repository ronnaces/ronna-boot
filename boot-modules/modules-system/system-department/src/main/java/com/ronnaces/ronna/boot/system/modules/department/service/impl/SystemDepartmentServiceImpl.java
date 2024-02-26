package com.ronnaces.ronna.boot.system.modules.department.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.department.mapper.SystemDepartmentMapper;
import com.ronnaces.ronna.boot.system.modules.department.service.ISystemDepartmentService;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemDepartmentServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@AllArgsConstructor
@Service
public class SystemDepartmentServiceImpl extends ServiceImpl<SystemDepartmentMapper, SystemDepartment> implements ISystemDepartmentService {

    private final SystemDepartmentMapper mapper;

}

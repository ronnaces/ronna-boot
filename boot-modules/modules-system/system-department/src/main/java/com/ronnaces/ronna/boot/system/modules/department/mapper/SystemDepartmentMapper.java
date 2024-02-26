package com.ronnaces.ronna.boot.system.modules.department.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemDepartmentMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Repository
public interface SystemDepartmentMapper extends BaseMapper<SystemDepartment> {

    List<SystemDepartment> findByIds(@Param("list") List<String> list);
}


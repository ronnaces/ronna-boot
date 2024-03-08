package com.ronnaces.ronna.boot.system.modules.role.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.role.permission.entity.SystemRolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SystemRolePermissionMapper extends BaseMapper<SystemRolePermission> {

    List<String> selectRelationshipId(@Param("id") String id, @Param("permissions") List<String> permissions);
}


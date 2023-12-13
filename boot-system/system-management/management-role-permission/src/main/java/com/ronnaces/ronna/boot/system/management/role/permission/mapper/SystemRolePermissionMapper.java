package com.ronnaces.ronna.boot.system.management.role.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.management.role.permission.entity.SystemRolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemRolePermissionMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-28
 */
@Repository
public interface SystemRolePermissionMapper extends BaseMapper<SystemRolePermission> {

    List<String> selectRolePermissionRelationshipId(@Param("id") String id, @Param("permissions") List<String> permissions);
}


package com.ronnaces.ronna.boot.system.management.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.management.role.entity.SystemRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemRoleMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Repository
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    List<String> findAllPermissionIdById(@Param("id") String id);

    List<SystemRole> findByRoles(@Param("roles") List<String> roles);

    List<SystemRole> findByUserId(@Param("userId") String userId);
}


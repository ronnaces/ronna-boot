package com.ronnaces.ronna.boot.system.management.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.management.permission.entity.SystemPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemPermissionMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Repository
public interface SystemPermissionMapper extends BaseMapper<SystemPermission> {

    List<SystemPermission> queryUserPermission(@Param("username") String username);

    List<SystemPermission> queryRolePermission(@Param("roleId") String roleId);

    List<String> findByCodes(@Param("codes") List<String> codes);

    List<SystemPermission> findByIds(@Param("list") List<String> list);
}


package com.ronnaces.ronna.boot.system.modules.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface SystemPermissionMapper extends BaseMapper<SystemPermission> {

    List<SystemPermission> queryUserPermission(@Param("userId") String userId);

    List<SystemPermission> queryRolePermission(@Param("roleId") String roleId);

    List<String> findByCodes(@Param("codes") List<String> codes);

    List<SystemPermission> findByIds(@Param("list") List<String> list);

    Set<String> findCodeByUserId(@Param("userId") String userId);
}


package com.ronnaces.ronna.boot.system.modules.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    List<String> findAllPermissionIdById(@Param("id") String id);

    List<SystemRole> findByIds(@Param("list") List<String> list);

    List<SystemRole> findByUserId(@Param("userId") String userId);

    Set<String> findCodeByUserId(@Param("userId") String userId);

    List<String> findByPermissionId(@Param("permissionId") String permissionId);
}


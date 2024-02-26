package com.ronnaces.ronna.boot.system.modules.user.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.user.role.entity.SystemUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemUserRoleMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-27
 */
@Repository
public interface SystemUserRoleMapper extends BaseMapper<SystemUserRole> {

    List<String> selectRelationshipId(@Param("id") String id, @Param("list") List<String> list);

}


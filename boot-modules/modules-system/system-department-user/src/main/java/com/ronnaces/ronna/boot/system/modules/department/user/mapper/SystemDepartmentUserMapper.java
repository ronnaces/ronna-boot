package com.ronnaces.ronna.boot.system.modules.department.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemDepartmentUserMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Repository
public interface SystemDepartmentUserMapper extends BaseMapper<SystemDepartmentUser> {

    List<String> selectRelationshipId(@Param("id") String id, @Param("list") List<String> list);

}


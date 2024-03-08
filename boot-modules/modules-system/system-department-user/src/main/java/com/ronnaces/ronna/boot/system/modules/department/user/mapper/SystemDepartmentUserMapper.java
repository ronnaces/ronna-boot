package com.ronnaces.ronna.boot.system.modules.department.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.department.user.entity.SystemDepartmentUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SystemDepartmentUserMapper extends BaseMapper<SystemDepartmentUser> {

    List<String> selectRelationshipId(@Param("id") String id, @Param("list") List<String> list);

}


package com.ronnaces.ronna.boot.system.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUser findByUsername(@Param("username") String username);

    SystemUser findByPhone(@Param("phone") String phone);

    List<String> findAllRoleIdById(@Param("id") String id);

    List<String> findByDeptId(@Param("deptId") String deptId);

    Map<String, Object> findDeptById(@Param("id") String id);
}


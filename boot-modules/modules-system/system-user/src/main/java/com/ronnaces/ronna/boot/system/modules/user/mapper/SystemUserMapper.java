package com.ronnaces.ronna.boot.system.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUser findByUsername(@Param("username") String username);

    SystemUser findByPhone(@Param("phone") String phone);

    List<String> findAllRoleCodeById(@Param("id") String id);

}


package com.ronnaces.ronna.boot.system.management.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemUserMapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-29
 */
@Repository
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUser findByUsername(@Param("username") String username);

    SystemUser findByPhone(@Param("phone") String phone);

    List<String> findAllRoleCodeById(@Param("id") String id);

}


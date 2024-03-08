package com.ronnaces.ronna.boot.system.modules.oauth2.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.oauth2.client.entity.SystemOauth2Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SystemOauth2ClientMapper extends BaseMapper<SystemOauth2Client> {

    SystemOauth2Client findByClientId(@Param("clientId") String clientId);

}


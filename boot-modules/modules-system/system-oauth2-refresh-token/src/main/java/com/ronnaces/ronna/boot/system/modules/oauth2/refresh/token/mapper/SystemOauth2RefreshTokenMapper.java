package com.ronnaces.ronna.boot.system.modules.oauth2.refresh.token.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.oauth2.refresh.token.entity.SystemOauth2RefreshToken;
import org.springframework.stereotype.Repository;


@Repository
public interface SystemOauth2RefreshTokenMapper extends BaseMapper<SystemOauth2RefreshToken> {

}


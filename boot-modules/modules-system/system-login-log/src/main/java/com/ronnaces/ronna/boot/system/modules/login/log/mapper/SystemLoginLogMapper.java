package com.ronnaces.ronna.boot.system.modules.login.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.login.log.entity.SystemLoginLog;
import org.springframework.stereotype.Repository;

/**
 * 登录日志表
 *
 * @author KunLong-Luo
 * @since 2024-01-10
 */
@Repository
public interface SystemLoginLogMapper extends BaseMapper<SystemLoginLog> {

}

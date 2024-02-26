package com.ronnaces.ronna.boot.system.modules.edit.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ronnaces.ronna.boot.system.modules.edit.log.entity.SystemEditLog;
import org.springframework.stereotype.Repository;

/**
 * 操作日志表
 *
 * @author KunLong-Luo
 * @since 2024-01-10
 */
@Repository
public interface SystemEditLogMapper extends BaseMapper<SystemEditLog> {

}

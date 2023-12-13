package com.ronnaces.ronna.boot.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mybatis-plus 自动填充组件
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/1/12 15:08
 */
@Slf4j
@Component
public class StaffCenterMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            log.info("======插入拦截添加公共字段,对象信息为");
            this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        } catch (Exception e) {
            log.error("插入拦截发生异常====信息为{}", e.getMessage());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            log.info("======执行修改拦截添加公共字段====");
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        } catch (Exception e) {
            log.error("修改拦截发生异常====信息为{}", e.getMessage());
        }
    }

}
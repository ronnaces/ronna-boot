package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Login
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRoleResponse {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

}

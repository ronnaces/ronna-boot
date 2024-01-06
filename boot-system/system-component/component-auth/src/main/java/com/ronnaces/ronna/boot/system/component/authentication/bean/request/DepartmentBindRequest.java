package com.ronnaces.ronna.boot.system.component.authentication.bean.request;

import lombok.*;

import java.util.List;

/**
 * Department Bind
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentBindRequest {

    private String userId;

    /**
     * departments
     */
    private List<String> departments;

}

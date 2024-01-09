package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import lombok.*;

import java.util.List;

/**
 * Bind Request
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
public class BindRequest {

    private String mainId;

    /**
     * minorIds
     */
    private List<String> minorIds;

}


package com.ronnaces.ronna.boot.system.component.auth2.service.security.model;

import lombok.Data;

@Data
public class ResetPasswordRequest {

    private String resetToken;

    private String password;
}

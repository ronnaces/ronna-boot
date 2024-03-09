package com.ronnaces.ronna.boot.system.component.auth2.service.security.auth;

import org.thingsboard.server.service.security.model.SecurityUser;

public class MfaAuthenticationToken extends AbstractJwtAuthenticationToken {
    public MfaAuthenticationToken(SecurityUser securityUser) {
        super(securityUser);
    }
}

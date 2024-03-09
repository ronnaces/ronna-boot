package com.ronnaces.ronna.boot.system.component.auth2.service.security.auth.jwt.settings;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.thingsboard.server.common.data.security.model.JwtSettings;


@Primary
@Profile("install")
@Component
@RequiredArgsConstructor
public class InstallJwtSettingsValidator implements JwtSettingsValidator {

    @Override
    public void validate(JwtSettings jwtSettings) {

    }

}

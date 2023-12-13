package com.ronnaces.ronna.boot.system.component.auth2.service;

public class RegisteredClientRepositoryImpl {

}
/*
package com.ronnaces.boot.system.component.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronnaces.loong.boot.system.management.oauth2.client.entity.SystemOauth2Client;
import com.ronnaces.loong.boot.system.management.oauth2.client.mapper.SystemOauth2ClientMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Component
public class com.ronnaces.boot.system.component.auth2.service.RegisteredClientRepositoryImpl implements RegisteredClientRepository {
public class com.ronnaces.boot.system.component.auth2.service.RegisteredClientRepositoryImpl implements RegisteredClientRepository {

    private final SystemOauth2ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void save(RegisteredClient registeredClient) {
        Assert.notNull(registeredClient, "registeredClient cannot be null");
        SystemOauth2Client existingRegisteredClient = clientMapper.selectById(registeredClient.getId());
        if (Objects.nonNull(existingRegisteredClient)) {
            updateRegisteredClient(registeredClient);
        } else {
            insertRegisteredClient(registeredClient);
        }
    }

    private void insertRegisteredClient(RegisteredClient registeredClient) {
        SystemOauth2Client client = new SystemOauth2Client();
        client.setId(registeredClient.getId());
        client.setClientId(registeredClient.getClientId());
        client.setClientName(registeredClient.getClientName());
        client.setClientAuthenticationMethods(StringUtils.collectionToCommaDelimitedString(registeredClient.getClientAuthenticationMethods()));
        client.setAuthorizationGrantTypes(StringUtils.collectionToCommaDelimitedString(registeredClient.getAuthorizationGrantTypes()));
        client.setClientSecret(passwordEncoder.encode(registeredClient.getClientSecret()));
        client.setRedirectUris(StringUtils.collectionToCommaDelimitedString(registeredClient.getAuthorizationGrantTypes()));
        client.setPostLogoutRedirectUris(StringUtils.collectionToCommaDelimitedString(registeredClient.getPostLogoutRedirectUris()));
        client.setScopes(StringUtils.collectionToCommaDelimitedString(registeredClient.getScopes()));
        client.setClientSettings(writeMap(registeredClient.getClientSettings().getSettings()));
        client.setTokenSettings(writeMap(registeredClient.getTokenSettings().getSettings()));
        client.setClientIdIssuedAt(LocalDateTime.ofInstant(registeredClient.getClientIdIssuedAt(), ZoneOffset.of("+8")));
        client.setClientSecretExpiresAt(LocalDateTime.ofInstant(registeredClient.getClientSecretExpiresAt(), ZoneOffset.of("+8")));

        clientMapper.insert(client);
    }

    private String writeMap(Map<String, Object> data) {
        try {
            return this.objectMapper.writeValueAsString(data);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }

    private void updateRegisteredClient(RegisteredClient registeredClient) {
        SystemOauth2Client client = new SystemOauth2Client();
        client.setId(registeredClient.getId());
        client.setClientId(registeredClient.getClientId());
        client.setClientName(registeredClient.getClientName());
        client.setClientAuthenticationMethods(StringUtils.collectionToCommaDelimitedString(registeredClient.getClientAuthenticationMethods()));
        client.setAuthorizationGrantTypes(StringUtils.collectionToCommaDelimitedString(registeredClient.getAuthorizationGrantTypes()));
        client.setClientSecret(passwordEncoder.encode(registeredClient.getClientSecret()));
        client.setRedirectUris(StringUtils.collectionToCommaDelimitedString(registeredClient.getAuthorizationGrantTypes()));
        client.setPostLogoutRedirectUris(StringUtils.collectionToCommaDelimitedString(registeredClient.getPostLogoutRedirectUris()));
        client.setScopes(StringUtils.collectionToCommaDelimitedString(registeredClient.getScopes()));
        client.setClientSettings(writeMap(registeredClient.getClientSettings().getSettings()));
        client.setTokenSettings(writeMap(registeredClient.getTokenSettings().getSettings()));
        client.setClientIdIssuedAt(LocalDateTime.ofInstant(registeredClient.getClientIdIssuedAt(), ZoneOffset.of("+8")));
        client.setClientSecretExpiresAt(LocalDateTime.ofInstant(registeredClient.getClientSecretExpiresAt(), ZoneOffset.of("+8")));
        client.setUpdateTime(LocalDateTime.now());

        clientMapper.updateById(client);
    }

    @Override
    public RegisteredClient findById(String id) {
        Assert.hasText(id, "id cannot be empty");
        SystemOauth2Client oauth2Client = clientMapper.selectById(id);
        return coverToBean(oauth2Client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Assert.hasText(clientId, "clientId cannot be empty");
        SystemOauth2Client oauth2Client = clientMapper.findByClientId(clientId);
        return coverToBean(oauth2Client);
    }

    private static RegisteredClient coverToBean(SystemOauth2Client oauth2Client) {
        if (Objects.isNull(oauth2Client)) {
            return null;
        }

        return RegisteredClient
                .withId(oauth2Client.getId())
                .clientId(oauth2Client.getClientId())
                .clientName(oauth2Client.getClientName())
                .clientSecret(oauth2Client.getClientSecret())
                .redirectUri(oauth2Client.getRedirectUris())
                .clientIdIssuedAt(oauth2Client.getClientIdIssuedAt().toInstant(ZoneOffset.of("+8")))
                .clientSecretExpiresAt(oauth2Client.getClientSecretExpiresAt().toInstant(ZoneOffset.of("+8")))
                .build();
    }
}


*/

package com.ronnaces.ronna.boot.mqtt.component.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties(MqttProperties.LOONG_PREFIX)
public class MqttProperties {

    public static final String LOONG_PREFIX = "loong.mqtt";


    private String[] serverURIs;

    private String clientId;


    private String username;


    private String password;


    private Integer keepAliveInterval;


    private Integer qos;


    private Boolean cleanStart;


    private Boolean automaticReconnect;

    private Integer automaticReconnectMinDelay;

    private Integer automaticReconnectMaxDelay;


    private Long completionTimeout;


    private int connectionTimeout;


    private int maxReconnectDelay;


    private String[] topic;

}

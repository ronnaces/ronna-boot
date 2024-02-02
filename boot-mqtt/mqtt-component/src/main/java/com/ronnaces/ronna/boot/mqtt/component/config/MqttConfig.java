package com.ronnaces.ronna.boot.mqtt.component.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.mqtt.inbound.Mqttv5PahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.Mqttv5PahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaderMapper;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;

/**
 * MQTTConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2024/1/9 17:06
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class MqttConfig {

    private final MqttProperties properties;

    private static final String MQTT_OUTBOUND = "outboundChannel";

    private static final String MQTT_INBOUND = "inboundChannel";

    @Bean
    public MessageChannel inboundChannel() {
        return MessageChannels.publishSubscribe().getObject();
    }

    @Bean
    public MessageChannel outboundChannel() {
        return MessageChannels.direct().getObject();
    }

    @Bean
    public MessageChannel errorChannel() {
        return MessageChannels.publishSubscribe().getObject();
    }

    @Bean
    public MessageProducer inbound(@Qualifier("connectOptions") MqttConnectionOptions mqttConnectionOptions) {
        Mqttv5PahoMessageDrivenChannelAdapter messageProducer = new Mqttv5PahoMessageDrivenChannelAdapter(mqttConnectionOptions, properties.getClientId(), properties.getTopic());
        messageProducer.setPayloadType(String.class);
        messageProducer.setManualAcks(false);
        messageProducer.setOutputChannel(inboundChannel());
        return messageProducer;
    }

    @Bean
    @ServiceActivator(inputChannel = MQTT_INBOUND)
    public MessageHandler handler() {
        return message -> log.debug("message = {}", message.getPayload());
    }

    @Bean
    @ServiceActivator(inputChannel = MQTT_OUTBOUND)
    public MessageHandler mqtt5Outbound(@Qualifier("connectOptions") MqttConnectionOptions mqttConnectionOptions) {
        Mqttv5PahoMessageHandler messageHandler = new Mqttv5PahoMessageHandler(mqttConnectionOptions, properties.getClientId());
        MqttHeaderMapper mqttHeaderMapper = new MqttHeaderMapper();
        mqttHeaderMapper.setOutboundHeaderNames(MqttHeaders.RESPONSE_TOPIC, MqttHeaders.CORRELATION_DATA, MessageHeaders.CONTENT_TYPE);
        messageHandler.setHeaderMapper(mqttHeaderMapper);
        messageHandler.setDefaultTopic(properties.getTopic()[0]);
        messageHandler.setDefaultQos(properties.getQos());
        messageHandler.setAsync(true);
        messageHandler.setAsyncEvents(true);
        return messageHandler;
    }

    @Bean
    public MqttConnectionOptions connectOptions() {
        MqttConnectionOptions options = new MqttConnectionOptions();
        options.setUserName(properties.getUsername());
        options.setPassword(properties.getPassword().getBytes());
        options.setServerURIs(properties.getServerURIs());
        options.setKeepAliveInterval(properties.getKeepAliveInterval());
        options.setAutomaticReconnect(properties.getAutomaticReconnect());
        options.setConnectionTimeout(properties.getConnectionTimeout());
        options.setMaxReconnectDelay(properties.getMaxReconnectDelay());
        options.setAutomaticReconnectDelay(properties.getAutomaticReconnectMinDelay(), properties.getAutomaticReconnectMaxDelay());
        options.setCleanStart(properties.getCleanStart());
//        options.setSessionExpiryInterval();
//        options.setReceiveMaximum();
//        options.setMaximumPacketSize();
//        options.setTopicAliasMaximum();
//        options.setRequestResponseInfo();
//        options.setRequestProblemInfo();
//        options.setUserProperties();
//        options.setAuthMethod();
//        options.setAuthData();
//        options.setSocketFactory();
//        options.setSSLProperties();
//        options.setSSLHostnameVerifier();
//        options.setUseSubscriptionIdentifiers();
//        options.setHttpsHostnameVerificationEnabled();
//        options.setCustomWebSocketHeaders();
//        options.setSendReasonMessages();
//        options.setExecutorServiceTimeout();
        return options;
    }
}

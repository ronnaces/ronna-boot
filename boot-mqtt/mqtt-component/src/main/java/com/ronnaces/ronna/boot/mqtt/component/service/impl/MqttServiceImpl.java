package com.ronnaces.ronna.boot.mqtt.component.service.impl;

import com.ronnaces.ronna.boot.mqtt.component.handler.MqttSendHandler;
import com.ronnaces.ronna.boot.mqtt.component.service.IMqttService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MqttServiceImpl implements IMqttService {

    @Autowired
    private final MqttSendHandler sendHandler;

    @Override
    public void sendToMqtt(String data) {
        sendHandler.sendToMqtt(data);
    }

    @Override
    public void sendToMqtt(Integer qos, String data) {
        sendHandler.sendToMqtt(qos, data);
    }

    @Override
    public void sendToMqtt(String topic, String data) {
        sendHandler.sendToMqtt(topic, data);
    }

    @Override
    public void sendToMqtt(String topic, Integer qos, String data) {
        sendHandler.sendToMqtt(topic, qos, data);
    }

    @Override
    public void sendToMqtt(String topic, String responseTopic, String correlationData, Integer qos, String data) {
        sendHandler.sendToMqtt(topic, responseTopic, correlationData, qos, data);
    }
}


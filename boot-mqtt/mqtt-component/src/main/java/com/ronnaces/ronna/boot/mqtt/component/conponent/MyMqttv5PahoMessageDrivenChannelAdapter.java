package com.ronnaces.ronna.boot.mqtt.component.conponent;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.integration.mqtt.inbound.Mqttv5PahoMessageDrivenChannelAdapter;

@Slf4j
public class MyMqttv5PahoMessageDrivenChannelAdapter extends Mqttv5PahoMessageDrivenChannelAdapter {

    public MyMqttv5PahoMessageDrivenChannelAdapter(String url, String clientId, String... topic) {
        super(url, clientId, topic);
    }

    public MyMqttv5PahoMessageDrivenChannelAdapter(MqttConnectionOptions connectionOptions, String clientId, String... topic) {
        super(connectionOptions, clientId, topic);
    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        if (reconnect) {
            log.info("重连需要重新订阅");
            reconnect = false;
        }
        super.connectComplete(reconnect, serverURI);
    }


}


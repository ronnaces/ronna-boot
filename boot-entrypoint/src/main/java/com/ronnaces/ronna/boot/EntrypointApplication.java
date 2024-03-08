package com.ronnaces.ronna.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@IntegrationComponentScan
@EnableAsync
@EnableRetry
@EnableAdminServer
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.ronnaces.ronna.boot","com.ronnaces.loong"})
public class EntrypointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrypointApplication.class, args);
    }
}

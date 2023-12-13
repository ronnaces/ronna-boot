package com.ronnaces.ronna.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * main
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/1/12 15:08
 */
@EnableAsync
@EnableRetry
@EnableAdminServer
//@EnableDiscoveryClient
@SpringBootApplication
public class EntrypointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrypointApplication.class, args);
    }
}

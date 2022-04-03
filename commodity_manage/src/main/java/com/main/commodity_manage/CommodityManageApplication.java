package com.main.commodity_manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author roxy
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CommodityManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommodityManageApplication.class, args);
    }
}

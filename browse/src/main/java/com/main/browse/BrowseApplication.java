package com.main.browse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author roxy
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BrowseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrowseApplication.class, args);
    }
}

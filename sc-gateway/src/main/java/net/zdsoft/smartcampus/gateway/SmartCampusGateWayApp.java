package net.zdsoft.smartcampus.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shenke
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SmartCampusGateWayApp {


    public static void main(String[] args) {
        SpringApplication.run(SmartCampusGateWayApp.class, args);
    }
}

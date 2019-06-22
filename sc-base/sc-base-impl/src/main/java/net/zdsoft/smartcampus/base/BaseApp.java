package net.zdsoft.smartcampus.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shenke
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BaseApp {

    public static void main(String[] args) {
        SpringApplication.run(BaseApp.class, args);
    }
}

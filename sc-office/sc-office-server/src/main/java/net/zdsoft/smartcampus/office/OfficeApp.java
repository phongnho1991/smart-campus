package net.zdsoft.smartcampus.office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenke
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "net.zdsoft.**.api")
public class OfficeApp {

    public static void main(String[] args) {
        SpringApplication.run(OfficeApp.class, args);
    }
}

package net.zdsoft.smartcampus.consumber.demo;

import net.zdsoft.smartcampus.base.User;
import net.zdsoft.smartcampus.base.api.UserApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shenke
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "net.zdsoft.smartcampus.**.api")
@RestController
public class DemoApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

    @Resource
    private UserApi userApi;

    @GetMapping("user")
    public User doGetUser() {
        return userApi.getUserById("402896b96b0783aa016b3efe369908ab");
    }
}

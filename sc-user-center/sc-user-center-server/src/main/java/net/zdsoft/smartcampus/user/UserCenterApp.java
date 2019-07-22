package net.zdsoft.smartcampus.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shenke
 */
@SpringBootApplication(
        exclude = UserDetailsServiceAutoConfiguration.class
)
@EnableDiscoveryClient
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApp.class, args);
    }

}

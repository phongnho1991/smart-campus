package net.zdsoft.smartcampus.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shenke
 */
@SpringBootApplication(
        exclude = UserDetailsServiceAutoConfiguration.class
)
@EnableSwagger2
@EnableDiscoveryClient
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApp.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("net.zdsoft.smartcampus.user.rest"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("User Center Api")
                .description("用户相关API")
                .version("1.0.0")
                .build();
    }
}

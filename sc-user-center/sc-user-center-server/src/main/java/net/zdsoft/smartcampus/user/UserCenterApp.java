package net.zdsoft.smartcampus.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;

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

    @Resource
    private ResourceServerProperties resourceServerProperties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("net.zdsoft.smartcampus.user.rest"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("User Center Api")
                .description("用户相关API")
                .version("1.0.0")
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8088/sc-auth/oauth/token");

        return new OAuthBuilder().grantTypes(Collections.singletonList(grantType))
                .name("oauth2")
                .scopes(Collections.singletonList(new AuthorizationScope("app", "app"))).build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                /*reference <==> securityScheme name */
                .securityReferences(Collections.singletonList(new SecurityReference("oauth2", new AuthorizationScope[]{new AuthorizationScope("app", "app")})))
                .forPaths(PathSelectors.any())
                .build();
    }
}

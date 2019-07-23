package net.zdsoft.smartcampus.boot.autoconfigure.swagger2;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import lombok.val;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shenke
 * @date 2019-07-12 15:14
 */
@Configuration
@EnableConfigurationProperties(Swagger2Properties.class)
public class Swagger2AutoConfiguration {

    @Resource
    private Swagger2Properties swagger2Properties;

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getApiSelector().getBasePackage()))
                .paths(compositePredicates())
                .build().apiInfo(apiEndPointsInfo())
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));

    }

    private Predicate<String> compositePredicates() {
        Predicate<String> antPath = input -> new AntPathMatcher().match(swagger2Properties.getApiSelector().getAnt(), input);
        Predicate<String> regex = input -> input.matches(swagger2Properties.getApiSelector().getRegex());
        return Predicates.or(Stream.of(antPath, regex).filter(Objects::nonNull).collect(Collectors.toList()));
    }

    private ApiInfo apiEndPointsInfo() {
        Swagger2Properties.ApiInfo api = swagger2Properties.getApiInfo();
        return new ApiInfoBuilder().title(api.getTitle())
                .description(api.getDescription())
                .version(api.getVersion())
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant("http://192.168.0.231:8088/sc-auth/oauth/token");

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

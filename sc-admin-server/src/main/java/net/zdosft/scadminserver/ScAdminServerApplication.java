package net.zdosft.scadminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class ScAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScAdminServerApplication.class, args);
    }

    @Bean
    public HttpHeadersProvider security() {
        return instance -> {
            HttpHeaders headers = new HttpHeaders();

            SecurityContext securityContext = SecurityContextHolder.getContext();
            if (securityContext == null) {
                return headers;
            }
            Authentication authentication = securityContext.getAuthentication();
            if (authentication == null) {
                return headers;
            }

            Object details = authentication.getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                headers.add("Authorization", "Bearer " + ((OAuth2AuthenticationDetails) details).getTokenValue());
            }
            return headers;
        };
    }
}

//package net.zdsoft.smartcampus.gateway.config;
//
//import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//import javax.annotation.Resource;
//
///**
// * @author shenke
// */
//@Configuration
//public class SecurityConfig {
//
//    @Resource
//    private TokenRelayGatewayFilterFactory relayGatewayFilterFactory;
//
//    //.route("resource", r -> r.path("/resource")
//    //        .filters(f -> f.filter(filterFactory.apply()))
//    //        .uri("http://localhost:9000"))
//
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        //RSAPublicKey publicKey =
//        http.authorizeExchange()
//                .and().authorizeExchange()
//                .pathMatchers("/sc-auth/login", "/sc-auth/logout", "/sc-auth/oauth/token", "/sc-auth/oauth/authorize", "/sc-auth/oauth/confirm_access","/logout", "/login/oauth2/**")
//                .permitAll()
//                .and().authorizeExchange().anyExchange().authenticated()
//                .and().csrf().disable()
//                .oauth2Login();
//        return http.build();
//    }
//}

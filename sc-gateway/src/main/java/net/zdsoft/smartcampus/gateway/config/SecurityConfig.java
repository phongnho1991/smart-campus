package net.zdsoft.smartcampus.gateway.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author shenke
 */
@Configuration
public class SecurityConfig {

    //@Resource
    //private TokenRelayGatewayFilterFactory relayGatewayFilterFactory;
    //
    ////.route("resource", r -> r.path("/resource")
    ////        .filters(f -> f.filter(filterFactory.apply()))
    ////        .uri("http://localhost:9000"))
    //
    //
    //@Bean
    //public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    //    //RSAPublicKey publicKey =
    //    http.authorizeExchange()
    //            .and()
    //            .authorizeExchange()
    //            .pathMatchers("/sc-auth/login", "/sc-auth/logout", "/sc-auth/oauth/token", "/sc-auth/oauth/authorize", "/sc-auth/oauth/confirm_access", "/logout", "/login/oauth2/**")
    //            .permitAll()
    //            .and()
    //            .authorizeExchange()
    //            .anyExchange().authenticated()
    //            .and().csrf().disable()
    //            .oauth2Login()
    //            .and()
    //            .logout().logoutSuccessHandler((exchange, authentication) -> {
    //                return Mono.fromRunnable(() -> {
    //                    ServerHttpResponse response = exchange.getExchange().getResponse();
    //                    response.setStatusCode(HttpStatus.FOUND);
    //                    String context = exchange.getExchange().getRequest().getPath().contextPath().value();
    //                    response.getHeaders().setLocation(URI.create(context + "/sc-auth/oauth/logout"));
    //                });
    //            });
    //    return http.build();
    //}
}

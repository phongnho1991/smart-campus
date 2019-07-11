package net.zdsoft.smartcampus.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

/**
 * @author shenke
 * @date 2019-07-09 10:11
 */
@Component
public class AccessTokenGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> implements InitializingBean {

    private PathPatternParser DEFAULT_PARSER = new PathPatternParser();

    private final LoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction;

    private WebClient webClient;

    public AccessTokenGatewayFilterFactory(LoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        this.loadBalancerExchangeFilterFunction = loadBalancerExchangeFilterFunction;
    }


    @Override
    public GatewayFilter apply(Object config) {

        PathPattern pattern = DEFAULT_PARSER.parse("/**/oauth/**");

        return (exchange, chain) -> {

            if (pattern.matches(exchange.getRequest().getPath().pathWithinApplication())) {
                return chain.filter(exchange);
            }
            String token = getAccessToken(exchange);
            if (!StringUtils.startsWith(token, BEARER_TOKEN_TYPE)) {
                //TODO body
                 ServerHttpResponse response = exchange.getResponse();
                 response.setStatusCode(HttpStatus.UNAUTHORIZED);
                 //response.bufferFactory().wrap()
                 return response.setComplete();
            }
            token = StringUtils.trim(token.replace(BEARER_TOKEN_TYPE, ""));

            return checkAccessToken(token).doOnError(e->{
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.BAD_GATEWAY);
                response.setComplete();
            }).hasElement().flatMap(e->chain.filter(exchange));
        };
    }

    private static final String OAUTH_TOKEN_PARAM_NAME = "token";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

    private String getAccessToken(ServerWebExchange exchange) {
        return exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
    }

    private Mono<Map> checkAccessToken(String token) {
        return webClient.get()
                .uri("/oauth/check_token?token=" + token)
                .retrieve()
                .bodyToMono(Map.class)
                .filter(Objects::nonNull)
                .filter(e->Boolean.TRUE.equals(e.get("active")));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        webClient = WebClient.builder().baseUrl("http://sc-auth")
                //.defaultUriVariables(Collections.singletonMap(OAUTH_TOKEN_PARAM_NAME, token))
                .filter(loadBalancerExchangeFilterFunction).build();
    }
}
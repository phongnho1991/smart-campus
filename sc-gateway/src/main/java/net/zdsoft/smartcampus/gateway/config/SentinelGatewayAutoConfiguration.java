package net.zdsoft.smartcampus.gateway.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author shenke
 */
@Configuration
public class SentinelGatewayAutoConfiguration {

    //private final List<ViewResolver> viewResolvers;
    //private final ServerCodecConfigurer serverCodecConfigurer;
    //
    //public SentinelGatewayAutoConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
    //                            ServerCodecConfigurer serverCodecConfigurer) {
    //    this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
    //    this.serverCodecConfigurer = serverCodecConfigurer;
    //}
    //
    //@Bean
    //@Order(Ordered.HIGHEST_PRECEDENCE)
    //public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
    //    // Register the block exception handler for Spring Cloud Gateway.
    //    return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    //}
    //
    //@Bean
    //@Order(Ordered.HIGHEST_PRECEDENCE)
    //public GlobalFilter sentinelGatewayFilter() {
    //    return new SentinelGatewayFilter();
    //}
}

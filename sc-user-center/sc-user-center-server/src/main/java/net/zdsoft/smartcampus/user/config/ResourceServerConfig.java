package net.zdsoft.smartcampus.user.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterRestTemplateCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import java.util.List;

/**
 * @author shenke
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/username", "/actuator/health").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
    }

    @Bean
    public JwtAccessTokenConverterRestTemplateCustomizer loadBalanceJwtAccessTokenRestTemplateCustomer(
            LoadBalancerInterceptor loadBalancerInterceptor) {
        return template-> {
            List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
            interceptors.add(loadBalancerInterceptor);
            template.setInterceptors(interceptors);
        };
    }

}
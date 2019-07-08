package net.zdosft.scadminserver;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author shenke
 * @date 2019-07-08 13:54
 */
@Configuration
@EnableOAuth2Sso
@Order(Ordered.HIGHEST_PRECEDENCE + 101)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/actuator", "/actuator/health", "/login", "/logout").permitAll()
                .and()
                .authorizeRequests().requestMatchers(EndpointRequest.toAnyEndpoint()).hasAuthority("sc-admin-server")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }
}

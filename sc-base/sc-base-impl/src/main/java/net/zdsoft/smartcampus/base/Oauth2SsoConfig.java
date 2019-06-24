package net.zdsoft.smartcampus.base;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenke
 */
@EnableOAuth2Sso
@Configuration
public class Oauth2SsoConfig {

    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
    //    http.logout().logoutSuccessUrl("http://localhost:8083/logout")
    //            .and()
    //            .formLogin().permitAll()
    //            .and()
    //            .authorizeRequests()
    //            .anyRequest().authenticated()
    //            .and()
    //            .csrf().disable();
    //}
}

package net.zdsoft.smartcampus.auth.controller;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shenke
 * @date 2019-07-10 14:02
 */
@RestController
@RequestMapping("oauth")
public class DestroyAccessTokenController {

    @Resource
    private TokenStore tokenStore;

    @GetMapping("/token/destroy")
    public Object destroy(HttpServletRequest request) {
        String token = (String) request.getAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE);
        tokenStore.removeAccessToken(new DefaultOAuth2AccessToken(token));
        return null;
    }
}

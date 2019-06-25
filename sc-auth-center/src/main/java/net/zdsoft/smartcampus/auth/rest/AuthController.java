package net.zdsoft.smartcampus.auth.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenke
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("/user")
    public Object authentication(@AuthenticationPrincipal Authentication authentication) {
        return authentication;
    }
}

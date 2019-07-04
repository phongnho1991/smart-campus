package net.zdsoft.smartcampus.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author shenke
 */
@Controller
@SessionAttributes("authorizationRequest")
public class AuthConfirmController {

    @RequestMapping("/szxy/oauth/confirm_access")
    public String confirm() {
        System.out.println("123");
        return "/confirm_access.html";
    }
}

package net.zdsoft.smartcampus.auth.oauth2.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenke
 */
@RestController
@RequestMapping("")
public class DemoController {

    @GetMapping("demo")
    public String execute() {
        return "demo";
    }
}

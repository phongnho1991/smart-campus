package net.zdsoft.smartcampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author shenke
 * @date 2019-07-22 17:27
 */
@Validated
@SpringBootApplication
@RestController
public class ValidatorApp {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApp.class, args);
    }


    @GetMapping("not-null")
    public Object notNullAction(@NotNull(message = "用户名不能为空") String username, BindingResult result) {
        return result;
    }
}

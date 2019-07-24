package net.zdsoft.smartcampus;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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



    @ResponseBody
    @GetMapping("not-null")
    public Object notNullAction(@RequestParam @Valid @Length(max = 1, message = "用户名不能为空") String username) {
        return null;
    }

    @ResponseBody
    @GetMapping("not-null-model")
    public Object notNullAction(@Valid User user, BindingResult result) {
        return JSONObject.toJSONString(result);
    }
}
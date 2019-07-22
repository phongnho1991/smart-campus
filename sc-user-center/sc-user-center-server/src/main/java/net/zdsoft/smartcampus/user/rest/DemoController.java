package net.zdsoft.smartcampus.user.rest;

import io.swagger.annotations.ApiOperation;
import net.zdsoft.smartcampus.user.Response;
import net.zdsoft.smartcampus.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenke
 * @date 2019-07-18 10:02
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @ApiOperation(value = "泛型测试")
    @GetMapping("user")
    public Response<User> doGetDemoUser() {

        return Response.success().data(new User());
    }
}

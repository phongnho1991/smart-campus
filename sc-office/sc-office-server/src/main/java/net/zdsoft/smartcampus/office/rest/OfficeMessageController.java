package net.zdsoft.smartcampus.office.rest;

import net.zdsoft.smartcampus.api.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shenke
 */
@RestController
@RequestMapping("message")
public class OfficeMessageController {

    @Resource
    private UserClient userClient;

    @GetMapping(value = "to-user", params = "userId")
    public String sendMessage(String userId) {
        userClient.getUsersByUnitId(userId);
        return "Message send ok";
    }
}

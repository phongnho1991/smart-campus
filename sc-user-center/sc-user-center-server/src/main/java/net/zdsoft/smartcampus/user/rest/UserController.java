package net.zdsoft.smartcampus.user.rest;

import net.zdsoft.smartcampus.api.UserClient;
import net.zdsoft.smartcampus.entity.User;
import net.zdsoft.smartcampus.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shenke
 */
@RestController
@RequestMapping("user")
public class UserController implements UserClient {

    @Resource
    private UserService userService;

    @Override
    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    public List<User> getUsersByUnitId(String unitId) {
        return null;
    }
}

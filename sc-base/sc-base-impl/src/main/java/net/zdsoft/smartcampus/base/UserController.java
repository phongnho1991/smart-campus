package net.zdsoft.smartcampus.base;

import net.zdsoft.smartcampus.base.api.UserApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author shenke
 */
@RestController
@RequestMapping("/base/user")
public class UserController implements UserApi {

    @Override
    public User getUserById(String id) {
        return new User().setId(id).setUsername(UUID.randomUUID().toString());
    }
}

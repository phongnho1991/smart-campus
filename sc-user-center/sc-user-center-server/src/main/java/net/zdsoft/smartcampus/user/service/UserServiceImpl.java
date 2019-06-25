package net.zdsoft.smartcampus.user.service;

import net.zdsoft.smartcampus.user.dao.UserRepository;
import net.zdsoft.smartcampus.user.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shenke
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElse(null);
    }
}

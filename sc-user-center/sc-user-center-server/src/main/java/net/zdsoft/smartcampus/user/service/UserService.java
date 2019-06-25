package net.zdsoft.smartcampus.user.service;

import net.zdsoft.smartcampus.user.entity.User;

/**
 * @author shenke
 */
public interface UserService {

    User getUserByUsername(String username);
}

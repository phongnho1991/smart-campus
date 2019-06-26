package net.zdsoft.smartcampus.user.service;

import net.zdsoft.smartcampus.user.entity.User;

import java.util.List;

/**
 * @author shenke
 */
public interface UserService {

    User getUserByUsername(String username);

    List<User> getUsersByUnitId(String unitId);
}

package net.zdsoft.smartcampus;

import net.zdsoft.smartcampus.entity.User;

/**
 * @author shenke
 * @date 2019-07-22 09:55
 */
public class FallbackFactory implements feign.hystrix.FallbackFactory<User> {

    @Override
    public User create(Throwable cause) {
        return null;
    }
}

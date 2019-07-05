package net.zdsoft.smartcampus.auth.config;

import net.zdsoft.smartcampus.api.UserClient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Objects;

/**
 * @author shenke
 */
@Component("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        net.zdsoft.smartcampus.entity.User user = userClient.getUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User %s not exists", username));
        }
        if ("like".equals(user.getUsername())) {
            return new User(username, user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("sc-admin-server")));
        }
        return new User(username, user.getPassword(), Collections.emptyList());
    }
}

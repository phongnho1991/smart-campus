package net.zdsoft.smartcampus.base.api;

import net.zdsoft.smartcampus.base.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shenke
 */
public interface UserApi {

    /**
     * Get user by id
     * @param id identity
     * @return User if exists or null
     */
    @GetMapping(
            value = "{id:\\w{32}}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    User getUserById(@PathVariable("id") String id);
}

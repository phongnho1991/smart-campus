package net.zdsoft.smartcampus.api;

import net.zdsoft.smartcampus.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author shenke
 */
@FeignClient(value = "sc-user-center", path = "user")
public interface UserClient {

    @GetMapping(value = "/username", params = "username")
    User getUserByUsername(@RequestParam String username);

    @GetMapping(value = "/unit-id", params = "unitId")
    List<? extends User> getUsersByUnitId(String unitId);
}

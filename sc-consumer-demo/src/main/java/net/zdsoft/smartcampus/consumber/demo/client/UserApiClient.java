package net.zdsoft.smartcampus.consumber.demo.client;

import net.zdsoft.smartcampus.base.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shenke
 */
//@FeignClient(name = "sc-base", path = "user")
public interface UserApiClient extends UserApi {

}

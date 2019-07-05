package net.zdsoft.smartcampus.user.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.models.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import net.zdsoft.smartcampus.api.UserClient;
import net.zdsoft.smartcampus.user.entity.User;
import net.zdsoft.smartcampus.user.service.UserService;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shenke
 */
@RestController
@RequestMapping("user")
@Api(value = "User", tags = "User", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController implements UserClient {

    @Resource
    private UserService userService;

    @ApiOperation(
            value = "根据用户名查询用户数据",
            response = User.class,
            notes = "查询指定用户名的用户信息（不包含软删的数据）",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponse(
            code = 200,
            response = User.class,
            message = "User"
    )
    @Override
    public User getUserByUsername(@ApiParam(value = "用户名", required = true) String username) {
        return userService.getUserByUsername(username);
    }

    //@PreAuthorize("hasAnyAuthority('sc-admin-server')")
    @Override
    public List<User> getUsersByUnitId(String unitId) {
        Object auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("auth is [{}]", auth);
        return userService.getUsersByUnitId(unitId);
    }
}
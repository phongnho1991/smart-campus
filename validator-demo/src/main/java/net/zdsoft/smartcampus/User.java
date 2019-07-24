package net.zdsoft.smartcampus;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author shenke
 * @date 2019-07-24 10:13
 */
@Data
public class User {

    @NotNull(message = "not null username")
    private String username;
}

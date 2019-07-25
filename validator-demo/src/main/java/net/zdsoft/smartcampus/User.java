package net.zdsoft.smartcampus;

import lombok.Data;
import net.zdsoft.smartcampus.common.validator.constraints.ChineseLength;
import net.zdsoft.smartcampus.common.validator.constraints.NotIn;

import javax.validation.constraints.NotNull;

/**
 * @author shenke
 * @date 2019-07-24 10:13
 */
@Data
public class User {

    @NotIn(targets = {"1", "2"}, message = "参数错误")
    @NotNull(message = "not null username")
    private String username;
}

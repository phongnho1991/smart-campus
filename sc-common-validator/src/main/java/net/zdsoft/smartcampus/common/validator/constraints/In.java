package net.zdsoft.smartcampus.common.validator.constraints;

import javax.validation.Payload;

/**
 * @author shenke
 * @date 2019-07-24 14:04
 */
public @interface In {

    String[] targets() default {};

    String message() default "{javax.validation.constraints.Null.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
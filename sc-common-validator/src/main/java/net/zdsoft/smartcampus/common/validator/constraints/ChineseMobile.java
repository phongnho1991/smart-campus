package net.zdsoft.smartcampus.common.validator.constraints;

import net.zdsoft.smartcampus.common.validator.constraintsvalidator.ChineseMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 手机号格式校验
 * @author shenke
 * @date 2019-07-24 13:53
 */
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ChineseMobileValidator.class)
public @interface ChineseMobile {

    /**
     * 是否严格模式
     */
    boolean strict() default false;

    String message() default "{net.zdsoft.smartcampus.common.validator.constraints.ChineseMobile.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

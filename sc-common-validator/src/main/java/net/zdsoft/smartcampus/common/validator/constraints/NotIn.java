package net.zdsoft.smartcampus.common.validator.constraints;

import net.zdsoft.smartcampus.common.validator.constraintsvalidator.NotInValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author shenke
 * @date 2019-07-24 14:04
 */
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NotInValidator.class)
public @interface NotIn {

    String[] targets() default {};

    String message() default "{net.zdsoft.smartcampus.common.validator.constraints.In.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

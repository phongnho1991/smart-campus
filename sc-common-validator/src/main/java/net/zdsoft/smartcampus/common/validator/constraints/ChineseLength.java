package net.zdsoft.smartcampus.common.validator.constraints;

import net.zdsoft.smartcampus.common.validator.constraintsvalidator.ChineseLengthValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 中文字符长度校验
 * @author shenke
 * @date 2019-07-24 13:52
 */
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ChineseLengthValidator.class)
public @interface ChineseLength {

    @Length
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "{net.zdsoft.smartcampus.common.validator.constraints.ChineseLength.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

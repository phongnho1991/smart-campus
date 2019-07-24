package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.utils.validator.PhoneUtils;
import net.zdsoft.smartcampus.common.validator.constraints.ChineseMobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shenke
 * @date 2019-07-24 15:45
 */
public class ChineseMobileValidator implements ConstraintValidator<ChineseMobile, String> {

    private boolean strict;

    @Override
    public void initialize(ChineseMobile constraintAnnotation) {
        this.strict = constraintAnnotation.strict();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        if (strict) {
            return PhoneUtils.isPhone(value);
        }

        return false;
    }
}

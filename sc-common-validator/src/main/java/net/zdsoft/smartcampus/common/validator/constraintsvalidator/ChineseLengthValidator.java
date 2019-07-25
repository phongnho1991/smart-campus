package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.utils.validator.Validators;
import net.zdsoft.smartcampus.common.validator.constraints.ChineseLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shenke
 * @date 2019-07-24 15:51
 */
public class ChineseLengthValidator implements ConstraintValidator<ChineseLength, String> {

    private int max;

    @Override
    public void initialize(ChineseLength constraintAnnotation) {
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return Validators.getRealLength(value) <= max;
    }
}

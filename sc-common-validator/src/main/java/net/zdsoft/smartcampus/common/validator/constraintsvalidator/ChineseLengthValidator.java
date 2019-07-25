package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.utils.validator.AssertUtils;
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
    private int min;

    @Override
    public void initialize(ChineseLength constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();

        AssertUtils.isTrue(min > 0, "The min can't be negative number");
        AssertUtils.isTrue(max > 0, "The max can't be negative number");
        AssertUtils.isTrue(max > min, "The length cannot be negative.");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        int length = Validators.getRealLength(value);
        return length >= min && length <= max;
    }
}

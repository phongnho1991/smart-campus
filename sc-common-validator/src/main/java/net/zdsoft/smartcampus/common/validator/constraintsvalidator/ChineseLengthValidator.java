package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.utils.OSUtils;
import net.zdsoft.smartcampus.common.validator.constraints.ChineseLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shenke
 * @date 2019-07-24 15:51
 */
public class ChineseLengthValidator implements ConstraintValidator<ChineseLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return false;
    }
}

package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.utils.validator.Validators;
import net.zdsoft.smartcampus.common.validator.constraints.ChineseIdentityCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shenke
 * @date 2019-07-24 14:15
 */
public class ChineseIdentityCardValidator implements ConstraintValidator<ChineseIdentityCard, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Validators.isIdCardNumber(value);
    }
}

package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.validator.constraints.NotIn;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author shenke
 * @date 2019-07-25 09:27
 */
public class NotInValidator implements ConstraintValidator<NotIn, String> {

    private String[] targets;

    @Override
    public void initialize(NotIn constraintAnnotation) {
        targets = constraintAnnotation.targets();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return Collections.binarySearch(Arrays.asList(targets), value) == -1;
    }
}

package net.zdsoft.smartcampus.common.validator.constraintsvalidator;

import net.zdsoft.smartcampus.common.validator.constraints.In;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author shenke
 * @date 2019-07-24 15:53
 */
public class InValidator implements ConstraintValidator<In, String> {

    private String[] targets;

    @Override
    public void initialize(In constraintAnnotation) {
        this.targets = constraintAnnotation.targets();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return Collections.binarySearch(Arrays.asList(targets), value) != -1;
    }
}

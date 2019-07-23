package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @author shenke
 * @date 2019-07-23 15:00
 */
public class ValidatorResponseBuilderImpl<T> extends BuilderImpl<T, ValidatorResponseBuilder<T>> implements ValidatorResponseBuilder<T> {

    private ResponseImpl<T> response = new ResponseImpl<>();

    protected BindingResult result;

    @Override
    protected ResponseImpl<T> getResponse() {
        return response;
    }

    @Override
    public ErrorBuilder<T> error(BindingResult errors) {
        this.result = errors;
        if (errors.hasErrors()) {
            getResponse().setSuccess(false);
        }

        if (errors.hasFieldErrors()) {
            getResponse().setErrors(errors.getFieldErrors());
        }

        if (errors.hasGlobalErrors()) {
            getResponse().setMessage(Objects.requireNonNull(errors.getGlobalError()).getDefaultMessage());
        }
        return new ValidatorResponseBuilder.ErrorBuilderImpl<>();
    }

}

package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @author shenke
 * @date 2019-07-22 15:48
 */
public class ResponseBuilderImpl<T> implements ResponseBuilder<T> {

    private ResponseImpl<T> response = new ResponseImpl<>();
    
    @Override
    public ResponseBuilder<T> ok() {
        response.setSuccess(true);
        return this;
    }

    @Override
    public ResponseBuilder<T> error() {
        response.setSuccess(false);
        return this;
    }

    @Override
    public ResponseBuilder<T> error(BindingResult errors) {
        if (errors.hasErrors()) {
            response.setSuccess(false);
        }

        if (errors.hasFieldErrors()) {
            response.setErrors(errors.getFieldErrors());
        }

        if (errors.hasGlobalErrors()) {
            response.setMessage(Objects.requireNonNull(errors.getGlobalError()).getDefaultMessage());
        }
        return this;
    }

    @Override
    public ResponseBuilder<T> message(String message) {
        response.setMessage(message);
        return this;
    }

    @Override
    public ResponseBuilder<T> message(String message, Object... args) {
        return this.message(String.format(message, args));
    }

    @Override
    public ResponseBuilder<T> data(T data) {
        response.setData(data);
        return this;
    }

    @Override
    public <R> ResponseBuilder<R> to(Class<R> target) {
        if (Objects.isNull(response.getData())) {
            return (ResponseBuilder<R>) this;
        }
        if (Objects.requireNonNull(target).isAssignableFrom(response.getData().getClass())) {
            return (ResponseBuilder<R>) this;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public Response<T> build() {
        return response;
    }

}

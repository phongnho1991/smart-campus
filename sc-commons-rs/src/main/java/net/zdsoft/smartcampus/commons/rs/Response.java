package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

/**
 * @author shenke
 * @date 2019-07-12 15:12
 */
public interface Response<T> {

    @Override
    String toString();

    static ResponseBuilder<Void> ok() {
        return new ResponseBuilderImpl<Void>().ok();
    }

    static <T> ResponseBuilder<T> ok(T data) {
        return new ResponseBuilderImpl<T>().data(data);
    }

    static ResponseBuilder<Void> error() {
        return new ResponseBuilderImpl<Void>().error();
    }

    static ResponseBuilder<Void> error(String message) {
        return error().message(message);
    }

    static ResponseBuilder<Void> error(String message, Object... args) {
        return error().message(message, args);
    }

    static ResponseBuilder<Void> error(BindingResult bindingResult) {
        return error().error(bindingResult);
    }
}

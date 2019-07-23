package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author shenke
 * @date 2019-07-12 15:12
 */
public interface Response<T> {

    @FunctionalInterface
    interface Execute {

        void execute();
    }

    @Override
    String toString();

    static ResponseBuilder<Void> ok() {
        return ok((Void) null);
    }

    static ResponseBuilder<Void> ok(Execute execute) {
        execute.execute();
        return ok();
    }

    static <T> ResponseBuilder<T> ok(T data) {
        return new ResponseBuilderImpl<T>().data(data);
    }

    static <T> ResponseBuilder<T> ok(Optional<T> data) {
        return ok(data.orElse(null));
    }

    static <T> ResponseBuilder<T> ok(Supplier<T> supplier) {
        return ok(Objects.requireNonNull(supplier).get());
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

    static <T> ValidatorResponseBuilder.ErrorBuilder<T> error(BindingResult bindingResult) {
        return new ValidatorResponseBuilder.ErrorBuilderImpl<T>().error(bindingResult);
    }


}

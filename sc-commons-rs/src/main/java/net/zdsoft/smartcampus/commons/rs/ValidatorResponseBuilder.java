package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author shenke
 * @date 2019-07-23 14:41
 */
public interface ValidatorResponseBuilder<T> extends Builder<T, ValidatorResponseBuilder<T>> {

    ErrorBuilder error(BindingResult errors);

    interface ErrorBuilder<T> extends ValidatorResponseBuilder<T> {

        ValidatorResponseBuilder<Void> or();

        ValidatorResponseBuilder<T> or(Supplier<T> supplier);

        <R> ValidatorResponseBuilder<T> or(Function<R, T> function);

        <R> ValidatorResponseBuilder<T> or(Consumer<R> consumer);
    }

    class ErrorBuilderImpl<T> extends ValidatorResponseBuilderImpl<T> implements ErrorBuilder<T> {

        @Override
        public ValidatorResponseBuilder<T> or(Supplier<T> supplier) {
            if (!getResponse().isSuccess()) {
                return this.ok().data(supplier);
            }
            return this;
        }

        @Override
        public <R> ValidatorResponseBuilder<T> or(Function<R, T> function) {
            if (!getResponse().isSuccess()) {
                return this.ok().data(function.apply((R) super.result.getTarget()));
            }
            return this;
        }

        @Override
        public <R> ValidatorResponseBuilder<T> or(Consumer<R> consumer) {
            if (!getResponse().isSuccess()) {
                consumer.accept((R) result.getTarget());
                return this.ok();
            }
            return null;
        }

        @Override
        public ValidatorResponseBuilder<Void> or() {
            return (ValidatorResponseBuilder<Void>) this.ok();
        }
    }
}

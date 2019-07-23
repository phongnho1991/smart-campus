package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

import java.util.function.Supplier;

/**
 * @author shenke
 * @date 2019-07-23 14:41
 */
public interface ValidatorResponseBuilder<T> extends Builder<T, ValidatorResponseBuilder<T>> {

    <R> Response<R> build();

    ErrorBuilder error(BindingResult errors);

    interface ErrorBuilder<T> extends ValidatorResponseBuilder<T> {

        ValidatorResponseBuilder<T> or(Supplier<T> supplier);

        //ValidatorResponseBuilder<T> or(Function<Object, T> function);
    }

    class ErrorBuilderImpl<T> extends ValidatorResponseBuilderImpl<T> implements ErrorBuilder<T> {

        @Override
        public ValidatorResponseBuilder<T> or(Supplier<T> supplier) {
            if (!getResponse().isSuccess()) {
                return this.ok().data(supplier);
            }
            return this;
        }

        //@Override
        //public ValidatorResponseBuilder<T> or(Function<Object, T> function) {
        //    if (!getResponse().isSuccess()) {
        //        return this.ok().data(function.apply(super.result.getTarget()));
        //    }
        //    return this;
        //}
    }
}

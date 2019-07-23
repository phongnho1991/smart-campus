package net.zdsoft.smartcampus.commons.rs;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author shenke
 * @date 2019-07-23 14:45
 */
public interface Builder<T, B extends Builder<T, B>> {

    //B noError(Supplier<T> supplier);

    B message(String message);

    B message(String message, Object... args);

    B data(T data);

    default B data(Supplier<T> supplier) {
        return this.data(Objects.requireNonNull(supplier).get());
    }

    Response<T> build();
}

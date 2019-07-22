package net.zdsoft.smartcampus.commons.rs;

import org.springframework.validation.BindingResult;

/**
 * @author shenke
 * @date 2019-07-12 15:15
 */
public interface ResponseBuilder<T> {

    ResponseBuilder<T> ok();

    ResponseBuilder<T> error();

    ResponseBuilder<T> error(BindingResult errors);

    ResponseBuilder<T> message(String message);

    ResponseBuilder<T> message(String message, Object... args);

    ResponseBuilder<T> data(T data);

    /**
     * 安全的类型转换
     * @see ClassCastException
     * @param target 泛型类型
     * @param <R> 泛型参数
     * @return this
     */
    <R> ResponseBuilder<R> to(Class<R> target);

    Response<T> build();
}

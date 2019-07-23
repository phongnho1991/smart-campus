package net.zdsoft.smartcampus.commons.rs;

/**
 * @author shenke
 * @date 2019-07-12 15:15
 */
public interface ResponseBuilder<T> extends Builder<T, ResponseBuilder<T>> {

    //ResponseBuilder<T> ok();

    //ResponseBuilder<T> error();



    /**
     * 安全的类型转换
     * @see ClassCastException
     * @param target 泛型类型
     * @param <R> 泛型参数
     * @return this
     */
    <R> ResponseBuilder<R> to(Class<R> target);
}

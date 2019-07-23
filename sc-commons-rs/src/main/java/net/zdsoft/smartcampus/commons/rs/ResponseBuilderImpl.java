package net.zdsoft.smartcampus.commons.rs;

import java.util.Objects;

/**
 * @author shenke
 * @date 2019-07-22 15:48
 */
public class ResponseBuilderImpl<T> extends BuilderImpl<T, ResponseBuilder<T>> implements ResponseBuilder<T> {

    private ResponseImpl<T> response = new ResponseImpl<>();

    @Override
    protected ResponseImpl<T> getResponse() {
        return response;
    }

    @Override
    public <R> ResponseBuilder<R> to(Class<R> target) {
        if (Objects.isNull(getResponse().getData())) {
            return (ResponseBuilder<R>) this;
        }
        if (Objects.requireNonNull(target).isAssignableFrom(getResponse().getData().getClass())) {
            return (ResponseBuilder<R>) this;
        } else {
            throw new ClassCastException();
        }
    }
}

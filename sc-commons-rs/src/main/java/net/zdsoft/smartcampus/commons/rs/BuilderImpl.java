package net.zdsoft.smartcampus.commons.rs;

/**
 * @author shenke
 * @date 2019-07-23 14:49
 */
public abstract class BuilderImpl<T, B extends Builder<T, B>> implements Builder<T, B> {

    protected abstract ResponseImpl<T> getResponse();

    B ok() {
        getResponse().setSuccess(true);
        return (B) this;
    }

    B error() {
        getResponse().setSuccess(false);
        return (B) this;
    }

    @Override
    public B data(T data) {
        getResponse().setData(data);
        return (B) this;
    }

    @Override
    public B message(String message) {
        getResponse().setMessage(message);
        return (B) this;
    }

    @Override
    public B message(String message, Object... args) {
        return message(String.format(message, args));
    }

    @Override
    public Response<T> build() {
        return getResponse();
    }
}

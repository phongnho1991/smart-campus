package net.zdsoft.smartcampus.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shenke
 * @date 2019-07-18 10:03
 */
@Data
@Accessors(chain = true)
public class Response<T> {

    private String message;
    private boolean success;
    private Integer code;
    @ApiModelProperty
    private T data;

    public static <C> Response<C> success() {
        Response<C> response = new Response<>();
        return response.setSuccess(true);
    }

    public <C extends T> Response<C> data(C data) {
        this.data = data;
        return (Response<C>) this;
    }
}

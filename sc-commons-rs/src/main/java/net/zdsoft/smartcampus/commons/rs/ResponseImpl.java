package net.zdsoft.smartcampus.commons.rs;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author shenke
 * @date 2019-07-22 15:42
 */
@Setter(AccessLevel.PROTECTED)
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ResponseImpl<T> implements Response<T> {

    @ApiModelProperty(value = "业务code")
    private Integer code;

    @ApiModelProperty(value = "一般用于错误信息")
    private String message;

    @ApiModelProperty(value = "是否成功标志")
    private boolean success;

    @ApiModelProperty
    private T data;

    @ApiModelProperty(value = "表单提交时，后端校验表单错误信息")
    private List<FieldError> errors;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

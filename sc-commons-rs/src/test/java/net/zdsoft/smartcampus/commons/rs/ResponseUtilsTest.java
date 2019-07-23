package net.zdsoft.smartcampus.commons.rs;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;

/**
 * @author shenke
 */
public class ResponseUtilsTest  {

    @Test
    public void testOk() {
        Response<Target> targetResponse = Response.ok(new ChildTarget()).to(Target.class).data(new Target()).build();
        System.out.println(JSONObject.toJSONString(targetResponse));

        BeanPropertyBindingResult result = new BeanPropertyBindingResult(new Target(), "target");
        result.addError(new ObjectError("target", "can't null"));

        System.out.println(JSONObject.toJSONString(execute(new Target(), result)));
    }

    public Response<List<String>> execute(@Validated Target target, BindingResult result) {

        ChildTarget c = new ChildTarget();

        return Response.error(result).or(c::getIds).build();



        //return Response.<List<String>>error(result).build();
    }





    public static class Target {

    }

    public static class ChildTarget extends Target {
        public List<String> getIds() {
            return Arrays.asList("1", "A");
        }
    }
}
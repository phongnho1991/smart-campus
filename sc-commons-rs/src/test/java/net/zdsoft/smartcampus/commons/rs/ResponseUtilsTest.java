package net.zdsoft.smartcampus.commons.rs;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;

/**
 * @author shenke
 */
public class ResponseUtilsTest  {

    @Test
    public void testOk() {
        Response<Target> targetResponse = Response.ok(new ChildTarget()).to(Target.class).data(new Target()).build();
        System.out.println(JSONObject.toJSONString(targetResponse));

    }

    public Response<List<String>> execute() {
        return null;
    }


    public static class Target {

    }

    public static class ChildTarget extends Target {

    }
}
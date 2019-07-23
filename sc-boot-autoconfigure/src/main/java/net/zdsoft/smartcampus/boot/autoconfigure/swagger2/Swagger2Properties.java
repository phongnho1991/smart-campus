package net.zdsoft.smartcampus.boot.autoconfigure.swagger2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shenke
 * @date 2019-07-22 20:04
 */
@Data
@ConfigurationProperties(prefix = "szxy.swagger2")
public class Swagger2Properties {

    private ApiInfo apiInfo;
    private ApiSelector apiSelector;
    private Docket docket;

    @Data
    public static class Docket {
        private boolean applyDefaultResponseMessages = false;
        private String groupName;
    }

    @Data
    public static class ApiInfo {
        private String version;
        private String title;
        private String description;
        private String termsOfServiceUrl;
        private String license;
        private String licenseUrl;
    }

    @Data
    public static class ApiSelector {
        private String basePackage;
        private String ant;
        private String regex;
    }
}

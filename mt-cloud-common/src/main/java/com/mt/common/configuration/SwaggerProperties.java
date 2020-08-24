package com.mt.common.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    private static final String TOKEN_KEY = "token";
    /**
     * swagger会解析的包路径
     **/
    private String basePackage = "com.mt";
    /**
     * swagger会解析的url规则
     **/
    private List<String> basePath = new ArrayList<>();
    /**
     * 在basePath基础上需要排除的url规则
     **/
    private List<String> excludePath = new ArrayList<>();
    /**
     * 标题
     **/
    private String title = "API";
    /**
     * 描述
     **/
    private String description = "接口文档";
    /**
     * 版本
     **/
    private String version = "2.0.0";
    /**
     * 许可证
     **/
    private String license = "";
    /**
     * 许可证URL
     **/
    private String licenseUrl = "";
    /**
     * 服务条款URL
     **/
    private String termsOfServiceUrl = "";

    /**
     * host信息
     **/
    private String host = "";
    /**
     * 联系人信息
     */
    private Contact contact = new Contact();
    /**
     * Token列表
     */
    private Set<String> headerTokenKeys = new HashSet<>();

    public Set<String> getHeaderTokenKeys() {
        if (headerTokenKeys != null) {
            headerTokenKeys.add(TOKEN_KEY);
        }
        return headerTokenKeys;
    }


    @Data
    @NoArgsConstructor
    static class Contact {

        /**
         * 联系人
         **/
        private String name = "motb";
        /**
         * 联系人url
         **/
        private String url = "";
        /**
         * 联系人email
         **/
        private String email = "xxxxx@163.com";

    }

}

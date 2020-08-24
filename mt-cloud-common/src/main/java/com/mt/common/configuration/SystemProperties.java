package com.mt.common.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("system")
public class SystemProperties {

    /**
     * 系统用户默认密码
     */
    private String defaultPwd = "123456";

    /**
     * 启用token拦截器
     */
    private boolean enableTokenAuth = false;

    /**
     * 启用线程池配置
     */
    private boolean enableThreadExecutor = false;
}

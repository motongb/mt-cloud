package com.mt.base.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Minio配置
 */
@Data
@ConfigurationProperties("minio")
public class MinioProperties {

    /**
     * 启用状态
     */
    private boolean enable = false;

    /**
     * IP端口
     */
    private String endpoint = "";

    /**
     * access
     */
    private String accessKey = "";

    /**
     * secret
     */
    private String secretKey = "";

//    @Bean
//    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
//        return new MinioClient(endpoint, accessKey, secretKey);
//    }
}


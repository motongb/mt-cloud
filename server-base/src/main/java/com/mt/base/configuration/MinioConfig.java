package com.mt.base.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Minio配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private boolean enable;

    private String endpoint;

    private String accessKey;

    private String secretKey;

//    @Bean
//    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
//        return new MinioClient(endpoint, accessKey, secretKey);
//    }
}


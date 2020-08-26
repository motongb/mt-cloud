package com.mt.middle.configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 为了本地开发方便，将minio设置关闭状态;
 * 本地电脑不能直接连接服务器上面的minio,报错No System TLS，待解决;
 */
@Getter
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {

    private MinioClient minioClient;

    @Autowired
    MinioAutoConfiguration(MinioProperties minioProperties) throws InvalidPortException, InvalidEndpointException {
        if (minioProperties.isEnable()) {
            this.minioClient = new MinioClient(minioProperties.getEndpoint(), minioProperties.getAccessKey(), minioProperties.getSecretKey());
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public MinioProperties minioProperties() {
        return new MinioProperties();
    }

}
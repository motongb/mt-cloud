package com.mt.base.configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 为了本地开发方便，将minio设置关闭状态;
 * 本地电脑不能直接连接服务器上面的minio,报错No System TLS，待解决;
 */
@Getter
@Component
public class MinioInstance {

    private MinioClient minioClient;

    @Autowired
    MinioInstance(MinioConfig minioConfig) throws InvalidPortException, InvalidEndpointException {
        if (minioConfig.isEnable()) {
            this.minioClient = new MinioClient(minioConfig.getEndpoint(), minioConfig.getAccessKey(), minioConfig.getSecretKey());
        }
    }

}
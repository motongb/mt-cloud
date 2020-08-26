package com.mt.common.configuration;

import com.mt.common.interceptor.FeignInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author motb
 * @date 2020/7/22 15:35
 * @description
 */
@EnableFeignClients(defaultConfiguration = FeignInterceptor.class, basePackages = "com.mt.api.*.feign")
public class FeignConfiguration {

}

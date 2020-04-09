package com.mt.provide2.configuration;

import com.mt.common.annotation.EnableAuthInterceptor;
import com.mt.common.interceptor.MybatisAuthInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author motb
 * @date 2020/3/26 0:11
 * @description:
 */
@Configuration
@EnableAuthInterceptor
@EnableConfigurationProperties(MybatisAuthInterceptor.class)
public class InterceptorConfig {
}

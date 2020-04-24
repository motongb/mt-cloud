package com.mt.base.configuration;

import com.mt.common.interceptor.MybatisAuthInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther: motb
 * @date: 2020/4/22 16:20
 * @description:
 */
@Configuration
@MapperScan(basePackages = "com.mt.base.dao")
@EnableConfigurationProperties(MybatisAuthInterceptor.class)
public class MybatisConfig {
}

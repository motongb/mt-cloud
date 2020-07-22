package com.mt.common.configuration;

import com.mt.common.interceptor.MybatisAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther: motb
 * @date: 2020/4/22 16:20
 * @description: mybatis拦截器配置
 */
@Configuration
@MapperScan(basePackages = "com.mt.**.dao")
public class MybatisConfig {

    @Bean
    public MybatisAuthInterceptor mybatisAuthInterceptor() {
        return new MybatisAuthInterceptor();
    }
}

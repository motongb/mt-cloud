package com.mt.base.configuration;

import com.mt.common.configuration.ThreadConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: motb
 * @date: 2020/4/24 16:52
 * @description: 线程池配置
 */
//@EnableScheduling//开启定时任务
@Configuration
@EnableConfigurationProperties(ThreadConfiguration.class)
public class ThreadConfig {

}

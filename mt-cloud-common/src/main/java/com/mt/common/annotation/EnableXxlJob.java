package com.mt.common.annotation;

import com.mt.common.configuration.XxlJobConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用xxl-job任务调度
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({XxlJobConfiguration.class})
public @interface EnableXxlJob {
}

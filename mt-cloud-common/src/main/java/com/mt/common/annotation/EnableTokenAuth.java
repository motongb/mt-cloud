package com.mt.common.annotation;

import com.mt.common.configuration.WebConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用token权限验证
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({WebConfig.class})
public @interface EnableTokenAuth {
}

package com.mt.common.annotation;

import com.mt.common.configuration.WebConfig;
import com.mt.common.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author motb
 * @date 2020/3/25 23:06
 * @description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({AuthInterceptor.class, WebConfig.class})
public @interface EnableAuthInterceptor {
}

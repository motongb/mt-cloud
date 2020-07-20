package com.mt.common.annotation;

import com.mt.common.configuration.ThreadConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author motb
 * 启用线程池注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ThreadConfiguration.class})
public @interface EnableThreadConfig {
}

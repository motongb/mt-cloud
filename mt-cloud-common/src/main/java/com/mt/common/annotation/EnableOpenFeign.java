package com.mt.common.annotation;

import com.mt.common.configuration.FeignConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author motb
 * @date 2020/7/22 15:34
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({FeignConfiguration.class})
public @interface EnableOpenFeign {
}

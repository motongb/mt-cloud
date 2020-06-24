package com.mt.common.annotation;

import com.mt.common.exception.ExceptionCatchController;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 全局异常捕获注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ExceptionCatchController.class})
public @interface EnableSysException {
}
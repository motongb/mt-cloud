package com.mt.common.exception;

import com.mt.common.http.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局controller异常处理类
 */
@Slf4j
@ControllerAdvice
public class ExceptionCatchController {

    @ResponseBody
    @ExceptionHandler(SysException.class)
    public HttpResult sysExceptionCatch(SysException e) {
        String message = e.getMessage();
        if (message == null) {
            message = e.getClass().getSimpleName();
        }
        log.warn(message, e);
        return HttpResult.fail(e.getCodeEnum());
    }


    /**
     * 捕获所有异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public HttpResult exceptionHandle(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            message = e.getClass().getSimpleName();
        }
        log.warn(message, e);
        return HttpResult.fail(message);
    }
}

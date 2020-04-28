package com.mt.common.http;

import com.mt.common.core.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author motb
 * @date 2020/3/25 17:49
 * @description: 请求返回
 */
@AllArgsConstructor
@Data
public class HttpResult<T> {

    private int code;

    private String message;

    private T data;

//    private HttpResult(){}

    private HttpResult(CodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
        this.data = data;
    }

    public static HttpResult success() {
        return success(null);
    }

    public static <T> HttpResult success(T data) {
        return new HttpResult<>(CodeEnum.SUCCESS, data);
    }

    public static HttpResult fail() {
        return fail(CodeEnum.FAIL);
    }

    public static HttpResult fail(CodeEnum codeEnum) {
        return new HttpResult<>(codeEnum, null);
    }

    public static HttpResult fail(String message) {
        return new HttpResult<>(CodeEnum.FAIL.getCode(), message, null);
    }
}

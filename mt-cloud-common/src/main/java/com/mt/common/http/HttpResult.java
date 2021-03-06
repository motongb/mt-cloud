package com.mt.common.http;

import com.mt.common.core.CodeEnum;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author motb
 * @date 2020/3/25 17:49
 * @description 请求返回
 */
@Data
@ApiModel("请求返回")
@AllArgsConstructor
public class HttpResult<T> {

    private int code;

    private String message;

    private T data;

    private HttpResult() {
    }

    private HttpResult(CodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
        this.data = data;
    }

    public static <T> HttpResult<T> success() {
        return success(null);
    }

    public static <T> HttpResult<T> success(T data) {
        return new HttpResult<>(CodeEnum.SUCCESS, data);
    }

    public static <T> HttpResult<T> fail() {
        return fail(CodeEnum.FAIL);
    }

    public static <T> HttpResult<T> fail(CodeEnum codeEnum) {
        return new HttpResult<>(codeEnum, null);
    }

    public static <T> HttpResult<T> fail(String message) {
        return new HttpResult<>(CodeEnum.FAIL.getCode(), message, null);
    }
}

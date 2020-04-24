package com.mt.common.core;

import lombok.Getter;

/**
 * @author motb
 * @date 2020/3/25 18:03
 * @description:
 */
@Getter
public enum CodeEnum {
    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 失败
     */
    FAIL(1, "fail"),

    /**
     * token 无效
     */
    TOKEN_INVALID(1000, "token invalid"),

    /**
     * token为空
     */
    TOKEN_EMPTY(1001, "token empty"),

    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXITS(1002, "account not exits"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR(1003, "password error"),

    /**
     * 参数无效
     */
    PARAMS_VALID(2000, "params valid");


    private int code;

    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

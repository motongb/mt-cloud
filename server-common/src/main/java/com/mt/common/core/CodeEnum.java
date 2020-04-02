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
    TOKEN_EMPTY(1001, "token empty");


    private int code;

    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

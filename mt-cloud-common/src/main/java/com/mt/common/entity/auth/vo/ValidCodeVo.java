package com.mt.common.entity.auth.vo;

import lombok.Data;

/**
 * @author motb
 * @date 2020/4/27 09:18
 * @description 缓存验证码
 */
@Data
public class ValidCodeVo {
    /**
     * 开始时间
     */
    private long startTime;
    /**
     * 有效期ms
     */
    private long expire = 30 * 1000L;
    /**
     * 验证码
     */
    private String validCode;
}

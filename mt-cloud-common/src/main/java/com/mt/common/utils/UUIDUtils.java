package com.mt.common.utils;

import java.util.UUID;

/**
 * @auther: motb
 * @date: 2020/4/14 11:33
 * @description:
 */
public abstract class UUIDUtils {

    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

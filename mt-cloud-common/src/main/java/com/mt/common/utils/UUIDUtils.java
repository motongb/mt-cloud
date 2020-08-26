package com.mt.common.utils;

import java.util.UUID;

/**
 * @author motb
 * @date 2020/4/14 11:33
 * @description
 */
public abstract class UUIDUtils {

    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

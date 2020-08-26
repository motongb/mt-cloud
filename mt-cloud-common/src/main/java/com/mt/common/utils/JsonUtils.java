package com.mt.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author motb
 * @date 2020/3/25 21:16
 * @description
 */
public abstract class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转成json字符串
     *
     * @param object
     * @return
     */
    public static String bean2String(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转成对象
     *
     * @param str
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T string2Bean(String str, Class<T> tClass) {
        try {
            return objectMapper.readValue(str, tClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * map转对象
     *
     * @param object
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T object2Bean(Object object, Class<T> tClass) {
        return objectMapper.convertValue(object, tClass);
    }
}

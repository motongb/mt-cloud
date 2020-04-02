package com.mt.common.core;

import com.mt.common.entity.sys.UserEntity;

/**
 * @author motb
 * @date 2020/3/25 22:51
 * @description: 当前用户信息
 */
public abstract class UserContext {

    private static final ThreadLocal<UserEntity> context = new ThreadLocal<>();

    public static MTEntity getContext() {
        return context.get();
    }

    public static void setContext(UserEntity userEntity) {
        context.set(userEntity);
    }

    public static void clear() {
        context.remove();
    }
}

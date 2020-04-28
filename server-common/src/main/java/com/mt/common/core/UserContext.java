package com.mt.common.core;

import com.mt.common.entity.base.UserEntity;
import com.mt.common.exception.SysException;

/**
 * @author motb
 * @date 2020/3/25 22:51
 * @description: 当前用户信息
 */
public abstract class UserContext {

    private static final ThreadLocal<UserEntity> context = new ThreadLocal<>();

    public static UserEntity getContext() {
        UserEntity currentUser = context.get();
        if (currentUser == null) {
            throw new SysException(CodeEnum.TOKEN_EMPTY);
        }
        return currentUser;
    }

    public static void setContext(UserEntity userEntity) {
        context.set(userEntity);
    }

    public static void clear() {
        context.remove();
    }
}

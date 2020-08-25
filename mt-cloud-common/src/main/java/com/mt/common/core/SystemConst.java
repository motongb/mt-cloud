package com.mt.common.core;

/**
 * @author motb
 * @date 2020/3/25 17:58
 * @description:
 */
public interface SystemConst {

    /**
     * 用户信息字段
     */
    String USER_INFO = "userInfo";

    /**
     * token_key
     */
    String TOKEN_KEY = "token";

    /**
     * 超级管理员
     */
    String ROLE_SUPER_ADMIN = "2";

    /**
     * 普通用户
     */
    String ROLE_NORMAL_USER = "0";

    /**
     * 功能
     */
    String FUNCTION = "function";

    /**
     * 菜单
     */
    String MENU = "menu";

    /**
     * 服务配置
     */
    interface ServerConfig {
        String MT_CLOUD_MIDDLE = "mt-cloud-middle";

        String MT_CLOUD_MIDDLE_FILE = "/file";
    }
}

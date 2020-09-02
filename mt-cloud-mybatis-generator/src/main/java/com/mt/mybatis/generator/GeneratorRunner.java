package com.mt.mybatis.generator;

import static com.mt.mybatis.generator.GeneratorUtils.genCode;

/**
 * @author motb
 * @date 2020/8/26 16:09
 * @description //TODO GeneratorRunner
 **/
public class GeneratorRunner {

    public static void main(String[] args) {
        genCode("sys_config", "sys_dict", "sys_menu", "sys_role", "sys_role_menu", "sys_user", "sys_user_role");
    }
}

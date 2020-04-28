package com.mt.common.entity.base.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author motb
 * @date 2020/3/25 20:42
 * @description: 登录信息
 */
@Data
public class LoginInfo {

    @NotBlank
    private String account;

    @NotBlank
    private String password;
}

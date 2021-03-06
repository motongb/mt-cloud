package com.mt.common.entity.auth.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author motb
 * @date 2020/3/25 20:42
 * @description 登录信息
 */
@Data
@ApiModel("登录信息")
public class LoginInfo {

    @NotBlank
    private String account;

    @NotBlank
    private String password;
}

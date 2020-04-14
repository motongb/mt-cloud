package com.mt.common.entity.sys;

import com.mt.common.core.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author motb
 * @date 2020/3/25 20:42
 * @description:
 */
@Data
@Table(name = "sys_user")
@ApiModel("用户实体")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty(value = "年龄", example = "0")
    private Integer age;
}

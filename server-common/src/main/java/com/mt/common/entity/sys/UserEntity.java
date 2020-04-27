package com.mt.common.entity.sys;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author motb
 * @date 2020/3/25 20:42
 * @description:
 */
@Data
@Table(name = "sys_user")
@ApiModel("用户类")
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

    @ApiModelProperty("邮箱")
    private String mail;

    @ApiModelProperty(value = "年龄", example = "0")
    private Integer age;

    @ApiModelProperty("用户类型：0-普通用户，1-管理员，2-超级管理员")
    private String type;

    @ApiModelProperty("职业")
    private String profession;

    @ApiModelProperty("身份证")
    private String identity;

    @ApiModelProperty("性别")
    private String sex;

    @Transient
    private List<RoleEntity> roles = new ArrayList<>();
}
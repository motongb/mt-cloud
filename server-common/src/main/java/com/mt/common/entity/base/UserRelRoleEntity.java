package com.mt.common.entity.base;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @auther: motb
 * @date: 2020/4/17 09:19
 * @description:
 */
@Data
@ApiModel("用户角色关联")
@Table(name = "sys_user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRelRoleEntity extends BaseEntity {

    @ApiModelProperty(value = "用户id", example = "0")
    private Long userId;

    @Transient
    private String userName;

    @ApiModelProperty(value = "角色id", example = "0")
    private Long roleId;

    @Transient
    private String roleName;
}

package com.mt.common.entity.sys;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

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

    @ApiModelProperty(value = "角色id", example = "0")
    private Long roleId;
}

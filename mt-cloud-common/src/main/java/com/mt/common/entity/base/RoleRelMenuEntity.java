package com.mt.common.entity.base;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author motb
 * @date 2020/4/14 16:10
 * @description
 */
@Data
@Table(name = "sys_role_menu")
@ApiModel("角色菜单关联")
@EqualsAndHashCode(callSuper = true)
public class RoleRelMenuEntity extends BaseEntity {

    @ApiModelProperty(value = "角色id", example = "0")
    private Long roleId;

    @ApiModelProperty(value = "菜单id", example = "0")
    private Long menuId;

    @Transient
    @ApiModelProperty("菜单类型")
    private String type;
}

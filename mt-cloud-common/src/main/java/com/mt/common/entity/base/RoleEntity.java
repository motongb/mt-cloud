package com.mt.common.entity.base;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author motb
 * @date 2020/4/14 14:33
 * @description
 */
@Data
@Table(name = "sys_role")
@ApiModel("角色类")
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("编码")
    private String code;
}

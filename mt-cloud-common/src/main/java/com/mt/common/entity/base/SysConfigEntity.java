package com.mt.common.entity.base;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @auther: motb
 * @date: 2020/5/14 14:50
 * @description:
 */
@Data
@Table(name = "sys_config")
@EqualsAndHashCode(callSuper = true)
public class SysConfigEntity extends BaseEntity {

    @ApiModelProperty("版本号")
    private String version;

    @ApiModelProperty("logo")
    private String logo;

    @ApiModelProperty("图标")
    private String ico;
}

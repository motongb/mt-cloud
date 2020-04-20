package com.mt.common.core.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.Order;

import javax.persistence.Id;

/**
 * @author motb
 * @date 2020/3/25 17:47
 * @description:
 */
@ApiModel(description = "基类")
@Data
public class BaseEntity {

    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty(value = "id", example = "0")
    private Long id;

    @ApiModelProperty(hidden = true)
    private String createTime;

    @ApiModelProperty(hidden = true)
    private String createBy;

    @Order(value = "DESC")
    @ApiModelProperty(hidden = true)
    private String updateTime;

    @ApiModelProperty(hidden = true)
    private String updateBy;
}

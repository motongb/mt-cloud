package com.mt.common.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

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

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("更新时间")
    private String updateTime;

    @ApiModelProperty("更新人")
    private String updateBy;
}

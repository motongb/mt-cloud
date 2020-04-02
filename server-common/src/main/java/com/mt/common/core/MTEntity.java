package com.mt.common.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author motb
 * @date 2020/3/25 17:47
 * @description:
 */
@ApiModel(description = "基类")
@Data
public class MTEntity {

    @ApiModelProperty(value = "id", example = "0")
    private Long id;
}

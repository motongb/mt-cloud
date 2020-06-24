package com.mt.common.entity.base;

import com.mt.common.core.base.BaseTreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tk.mybatis.mapper.annotation.Order;

import javax.persistence.Table;

/**
 * @auther: motb
 * @date: 2020/5/12 16:31
 * @description: 字典
 */
@Data
@Table(name = "sys_dict")
@ApiModel("字典类")
@EqualsAndHashCode(callSuper = true)
public class DictEntity extends BaseTreeEntity {
    @ApiModelProperty("字典编码")
    private String code;

    @Order(priority = 0)
    @ApiModelProperty(value = "排序", example = "0")
    private Integer sort;
}

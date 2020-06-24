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
 * @date: 2020/4/13 16:20
 * @description: 菜单类
 */
@Data
@Table(name = "sys_menu")
@ApiModel("菜单类")
@EqualsAndHashCode(callSuper = true)
public class MenuEntity extends BaseTreeEntity {

    @ApiModelProperty("类型:menu-菜单,function-功能")
    private String type;

    @ApiModelProperty("编码")
    private String code;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("图标")
    private String icon;

    @Order(priority = 0)
    @ApiModelProperty(value = "排序", example = "0")
    private Integer sort;
}

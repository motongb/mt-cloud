package com.mt.common.core.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author motb
 * @date 2020/4/13 16:23
 * @description
 */
@Data
@ApiModel("树表")
@EqualsAndHashCode(callSuper = true)
public class BaseTreeEntity extends BaseEntity {

    @ApiModelProperty("树id")
    private String treeId;

    @ApiModelProperty("父id")
    private String parentTreeId;

    @ApiModelProperty("所有父id")
    private String parentTreeIds;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父级名")
    private String parentNames;

    @Transient
    @ApiModelProperty("子级")
    private List<BaseTreeEntity> children = new ArrayList<>();
}

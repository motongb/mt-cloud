package com.mt.common.entity.book;

import com.mt.common.core.base.BaseEntity;
import com.mt.common.entity.base.FileEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author motb
 * @date 2020/4/27 16:28
 * @description
 */
@Data
@Table(name = "book")
@ApiModel("书本类")
@EqualsAndHashCode(callSuper = true)
public class BookEntity extends BaseEntity {

    @ApiModelProperty("书名")
    private String name;

    @ApiModelProperty("出版时间")
    private String publishTime;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("描述")
    private String remark;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("标签")
    private String tags;

    @ApiModelProperty("下载地址")
    private String url;

    @Transient
    @ApiModelProperty
    private List<FileEntity> files = new ArrayList<>();
}

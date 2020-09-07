package com.mt.common.entity.middle;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author motb
 * @date 2020/4/27 16:35
 * @description
 */
@Data
@Table(name = "file")
@ApiModel("文件类")
@EqualsAndHashCode(callSuper = true)
public class FileEntity extends BaseEntity {

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("文件路径")
    private String filePath;

    @ApiModelProperty("业务id")
    private Long relateId;
}

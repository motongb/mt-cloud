package com.mt.common.entity.base;

import com.mt.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @auther: motb
 * @date: 2020/4/27 16:35
 * @description:
 */
@Data
@Table(name = "sys_file")
@EqualsAndHashCode(callSuper = true)
public class FileEntity extends BaseEntity {

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("文件路径")
    private String filePath;

    @ApiModelProperty("业务id")
    private Long relateId;
}

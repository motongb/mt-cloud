package com.mt.base.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.base.FileEntity;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * @auther: motb
 * @date: 2020/4/27 16:38
 * @description:
 */
public interface FileMapper extends SysBaseMapper<FileEntity>, InsertListMapper<FileEntity> {
}

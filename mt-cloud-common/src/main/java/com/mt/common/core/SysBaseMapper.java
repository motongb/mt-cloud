package com.mt.common.core;

import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;

/**
 * @Auther: motb
 * @Date: 2020/4/9 15:22
 * @Description: 基础mapper
 */
@RegisterMapper
public interface SysBaseMapper<T> extends BaseMapper<T>, DeleteByIdListMapper<T, Long>, SelectByExampleMapper<T> {
}

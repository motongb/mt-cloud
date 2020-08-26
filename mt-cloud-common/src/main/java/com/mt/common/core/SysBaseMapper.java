package com.mt.common.core;

import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;

import java.util.List;

/**
 * @author motb
 * @date 2020/4/9 15:22
 * @description 基础mapper
 */
@RegisterMapper
public interface SysBaseMapper<T> extends BaseMapper<T>, DeleteByIdListMapper<T, Long>, SelectByExampleMapper<T>, InsertListMapper<T> {

    List<T> selectByList(T t);
}

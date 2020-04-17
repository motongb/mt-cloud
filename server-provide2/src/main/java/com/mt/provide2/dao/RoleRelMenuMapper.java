package com.mt.provide2.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.sys.RoleRelMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * @auther: motb
 * @date: 2020/4/14 16:40
 * @description:
 */
@Mapper
public interface RoleRelMenuMapper extends SysBaseMapper<RoleRelMenuEntity>, InsertListMapper<RoleRelMenuEntity> {
}

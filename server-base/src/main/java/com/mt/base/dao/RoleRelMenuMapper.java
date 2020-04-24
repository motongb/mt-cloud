package com.mt.base.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.sys.RoleRelMenuEntity;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/14 16:40
 * @description:
 */
public interface RoleRelMenuMapper extends SysBaseMapper<RoleRelMenuEntity>, InsertListMapper<RoleRelMenuEntity> {

    List<RoleRelMenuEntity> selectByRoleId(Long roleId);
}

package com.mt.base.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.sys.UserRelRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * @auther: motb
 * @date: 2020/4/17 09:22
 * @description:
 */
@Mapper
public interface UserRelRoleMapper extends SysBaseMapper<UserRelRoleEntity>, InsertListMapper<UserRelRoleEntity> {
}

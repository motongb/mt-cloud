package com.mt.base.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.base.MenuEntity;
import com.mt.common.entity.base.UserRelRoleEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.additional.insert.InsertListMapper;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/17 09:22
 * @description:
 */
public interface UserRelRoleMapper extends SysBaseMapper<UserRelRoleEntity>, InsertListMapper<UserRelRoleEntity> {

    List<UserRelRoleEntity> selectByRoleId(Long roleId);

    List<MenuEntity> selectMenuByUserId(@Param("userId") Long userId, @Param("type") String type);
}

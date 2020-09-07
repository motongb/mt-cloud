package com.mt.auth.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.auth.MenuEntity;
import com.mt.common.entity.auth.UserRelRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author motb
 * @date 2020/4/17 09:22
 * @description
 */
public interface UserRelRoleMapper extends SysBaseMapper<UserRelRoleEntity> {

    List<UserRelRoleEntity> selectByRoleId(Long roleId);

    List<MenuEntity> selectMenuByUserId(@Param("userId") Long userId, @Param("type") String type);
}

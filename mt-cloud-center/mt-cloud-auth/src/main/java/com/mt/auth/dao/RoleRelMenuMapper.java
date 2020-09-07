package com.mt.auth.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.auth.RoleRelMenuEntity;

import java.util.List;

/**
 * @author motb
 * @date 2020/4/14 16:40
 * @description
 */
public interface RoleRelMenuMapper extends SysBaseMapper<RoleRelMenuEntity> {

    List<RoleRelMenuEntity> selectByRoleId(Long roleId);
}

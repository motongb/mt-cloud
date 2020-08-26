package com.mt.auth.service;

import com.mt.auth.dao.UserRelRoleMapper;
import com.mt.common.core.base.BaseService;
import com.mt.common.entity.base.MenuEntity;
import com.mt.common.entity.base.UserEntity;
import com.mt.common.entity.base.UserRelRoleEntity;

import java.util.List;

/**
 * @author motb
 * @date 2020/8/25 16:41
 * @description //TODO UserRelRoleService
 **/
public interface UserRelRoleService extends BaseService<UserRelRoleEntity, UserRelRoleMapper> {

    void saveList(Long roleId, List<Long> userIds);

    List<MenuEntity> getMenu(UserEntity userEntity);

    List<String> getAccess(UserEntity userEntity);
}

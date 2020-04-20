package com.mt.base.service;

import com.mt.base.dao.UserRelRoleMapper;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.sys.UserRelRoleEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/17 09:22
 * @description:
 */
@Service
public class UserRelRoleService extends BaseServiceImpl<UserRelRoleEntity, UserRelRoleMapper> {

    /**
     * 批量新增
     *
     * @param userRelRoleEntities
     */
    public void saveList(Long roleId, List<UserRelRoleEntity> userRelRoleEntities) {
        UserRelRoleEntity relRoleEntity = new UserRelRoleEntity();
        relRoleEntity.setRoleId(roleId);
        getBaseMapper().delete(relRoleEntity);
        if (!CollectionUtils.isEmpty(userRelRoleEntities)) {
            getBaseMapper().insertList(userRelRoleEntities);
        }
    }
}

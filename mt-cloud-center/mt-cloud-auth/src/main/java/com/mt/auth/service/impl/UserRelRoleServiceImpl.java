package com.mt.auth.service.impl;

import com.mt.auth.dao.UserRelRoleMapper;
import com.mt.auth.service.MenuService;
import com.mt.auth.service.UserRelRoleService;
import com.mt.common.core.SystemConst;
import com.mt.common.core.TreeBuilder;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.base.MenuEntity;
import com.mt.common.entity.base.UserEntity;
import com.mt.common.entity.base.UserRelRoleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author motb
 * @date 2020/4/17 09:22
 * @description
 */
@Service
@AllArgsConstructor
public class UserRelRoleServiceImpl extends BaseServiceImpl<UserRelRoleEntity, UserRelRoleMapper> implements UserRelRoleService {

    private MenuService menuService;

    /**
     * 批量新增
     *
     * @param userIds
     */
    @Override
    public void saveList(Long roleId, List<Long> userIds) {
        UserRelRoleEntity relRoleEntity = new UserRelRoleEntity();
        relRoleEntity.setRoleId(roleId);
        getBaseMapper().delete(relRoleEntity);
        if (!CollectionUtils.isEmpty(userIds)) {
            List<UserRelRoleEntity> userRelRoleEntities = userIds.stream()
                    .map(userId -> {
                        UserRelRoleEntity item = new UserRelRoleEntity();
                        item.setUserId(userId);
                        item.setRoleId(roleId);
                        return item;
                    }).collect(Collectors.toList());
            getBaseMapper().insertList(userRelRoleEntities);
        }
    }

    /**
     * 获取用户菜单列表
     *
     * @param userEntity
     * @return
     */
    private List<MenuEntity> getUserMenuList(UserEntity userEntity, String type) {
        List<MenuEntity> menuEntityList;
        if (SystemConst.ROLE_SUPER_ADMIN.equals(userEntity.getType())) {
            Example example = new Example(MenuEntity.class);
            example.and().andEqualTo("type", type);
            menuEntityList = menuService.getBaseMapper().selectByExample(example);
        } else {
            menuEntityList = getBaseMapper().selectMenuByUserId(userEntity.getId(), type);
        }
        return menuEntityList;
    }

    /**
     * 获取用户菜单树
     *
     * @param userEntity
     * @return
     */
    @Override
    public List<MenuEntity> getMenu(UserEntity userEntity) {
        return TreeBuilder.build(getUserMenuList(userEntity, SystemConst.MENU));
    }

    /**
     * 获取用户权限
     *
     * @param userEntity
     * @return
     */
    @Override
    public List<String> getAccess(UserEntity userEntity) {
        return getUserMenuList(userEntity, SystemConst.FUNCTION).stream().map(MenuEntity::getCode).collect(Collectors.toList());
    }
}

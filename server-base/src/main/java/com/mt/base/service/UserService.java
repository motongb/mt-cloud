package com.mt.base.service;

import com.github.pagehelper.PageHelper;
import com.mt.base.dao.UserMapper;
import com.mt.common.core.PageResult;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.sys.UserEntity;
import com.mt.common.entity.sys.UserRelRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: motb
 * @date: 2020/4/9 16:33
 * @description:
 */
@Service
public class UserService extends BaseServiceImpl<UserEntity, UserMapper> {

    @Value("${user.defaultPwd}")
    private String defaultPwd;

    @Autowired
    private UserRelRoleService userRelRoleService;

    @Override
    public UserEntity save(UserEntity userEntity) {
        if (StringUtils.isEmpty(userEntity.getPassword())) {
            userEntity.setPassword(defaultPwd);
        }
        getBaseMapper().insertSelective(userEntity);
        if (!CollectionUtils.isEmpty(userEntity.getRoles())) {
            handleRole(userEntity);
        }
        return userEntity;
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        getBaseMapper().updateByPrimaryKeySelective(userEntity);
        UserRelRoleEntity query = new UserRelRoleEntity();
        query.setUserId(userEntity.getId());
        userRelRoleService.getBaseMapper().delete(query);
        if (!CollectionUtils.isEmpty(userEntity.getRoles())) {
            handleRole(userEntity);
        }
        return userEntity;
    }

    @Override
    public PageResult<UserEntity> listByPage(Integer pageNum, Integer pageSize, Object example) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> result = getBaseMapper().selectByList((UserEntity) example);
        return PageResult.paresPage(result);
    }

    /**
     * 处理角色
     *
     * @param userEntity
     */
    private void handleRole(UserEntity userEntity) {
        List<UserRelRoleEntity> roleEntities = userEntity.getRoles()
                .stream().map(item -> {
                    UserRelRoleEntity relRoleEntity = new UserRelRoleEntity();
                    relRoleEntity.setRoleId(item.getId());
                    relRoleEntity.setUserId(userEntity.getId());
                    return relRoleEntity;
                }).collect(Collectors.toList());
        userRelRoleService.getBaseMapper().insertList(roleEntities);
    }
}

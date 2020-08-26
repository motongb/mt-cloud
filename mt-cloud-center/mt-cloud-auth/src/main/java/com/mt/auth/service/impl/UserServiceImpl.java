package com.mt.auth.service.impl;

import com.mt.auth.dao.UserMapper;
import com.mt.auth.service.UserRelRoleService;
import com.mt.auth.service.UserService;
import com.mt.common.configuration.SystemProperties;
import com.mt.common.core.SystemConst;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.base.UserEntity;
import com.mt.common.entity.base.UserRelRoleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author motb
 * @date 2020/4/9 16:33
 * @description
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserMapper> implements UserService {

    private SystemProperties systemProperties;

    private UserRelRoleService userRelRoleService;

    /**
     * 账号注册
     *
     * @param userEntity 用户信息
     */
    @Override
    public void register(UserEntity userEntity) {
        userEntity.setType(SystemConst.ROLE_NORMAL_USER);
        save(userEntity);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        String password = StringUtils.isEmpty(userEntity.getPassword()) ? systemProperties.getDefaultPwd() : userEntity.getPassword();
        userEntity.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
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
        userRelRoleService.delete(query);
        if (!CollectionUtils.isEmpty(userEntity.getRoles())) {
            handleRole(userEntity);
        }
        return userEntity;
    }

    /**
     * 处理角色
     *
     * @param userEntity 用户
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

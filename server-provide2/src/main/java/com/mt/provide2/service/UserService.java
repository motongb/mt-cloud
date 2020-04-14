package com.mt.provide2.service;

import com.mt.common.core.BaseServiceImpl;
import com.mt.common.entity.sys.UserEntity;
import com.mt.provide2.dao.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @auther: motb
 * @date: 2020/4/9 16:33
 * @description:
 */
@Service
public class UserService extends BaseServiceImpl<UserEntity, UserMapper> {

    @Value("${user.defaultPwd}")
    private String defaultPwd;

    @Override
    public UserEntity save(UserEntity userEntity) {
        if (StringUtils.isEmpty(userEntity.getPassword())) {
            userEntity.setPassword(defaultPwd);
        }
        getBaseMapper().insertSelective(userEntity);
        return userEntity;
    }
}

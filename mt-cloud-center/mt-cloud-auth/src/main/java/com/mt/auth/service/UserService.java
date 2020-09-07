package com.mt.auth.service;

import com.mt.auth.dao.UserMapper;
import com.mt.common.core.base.BaseService;
import com.mt.common.entity.auth.UserEntity;

/**
 * @author motb
 * @date 2020/8/26 10:52
 * @description //TODO UserService
 **/
public interface UserService extends BaseService<UserEntity, UserMapper> {

    void register(UserEntity userEntity);
}

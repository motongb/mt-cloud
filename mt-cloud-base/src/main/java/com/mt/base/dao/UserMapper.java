package com.mt.base.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.base.UserEntity;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/9 15:26
 * @description:
 */
public interface UserMapper extends SysBaseMapper<UserEntity> {

    List<UserEntity> selectByList(UserEntity userEntity);
}

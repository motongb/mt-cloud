package com.mt.base.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.sys.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/9 15:26
 * @description:
 */
@Mapper
public interface UserMapper extends SysBaseMapper<UserEntity> {

    List<UserEntity> selectByList(UserEntity userEntity);
}

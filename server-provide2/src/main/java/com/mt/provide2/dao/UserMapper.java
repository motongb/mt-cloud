package com.mt.provide2.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.sys.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther: motb
 * @date: 2020/4/9 15:26
 * @description:
 */
@Mapper
public interface UserMapper extends SysBaseMapper<UserEntity> {
}

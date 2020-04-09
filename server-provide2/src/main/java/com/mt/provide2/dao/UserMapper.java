package com.mt.provide2.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.sys.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: motb
 * @Date: 2020/4/9 15:26
 * @Description:
 */
@Mapper
public interface UserMapper extends SysBaseMapper<UserEntity> {
}

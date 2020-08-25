package com.mt.auth.service;

import com.mt.auth.dao.RoleRelMenuMapper;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.base.RoleRelMenuEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/14 16:42
 * @description:
 */
@Service
public class RoleRelMenuService extends BaseServiceImpl<RoleRelMenuEntity, RoleRelMenuMapper> {

    public void saveList(List<RoleRelMenuEntity> relMenuEntityList) {
        getBaseMapper().insertList(relMenuEntityList);
    }
}

package com.mt.provide2.service;

import com.mt.common.core.BaseServiceImpl;
import com.mt.common.entity.sys.RoleRelMenuEntity;
import com.mt.provide2.dao.RoleRelMenuMapper;
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

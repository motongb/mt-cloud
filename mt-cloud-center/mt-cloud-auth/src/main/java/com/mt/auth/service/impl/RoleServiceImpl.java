package com.mt.auth.service.impl;

import com.mt.auth.dao.RoleMapper;
import com.mt.auth.service.RoleService;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.base.RoleEntity;
import org.springframework.stereotype.Service;

/**
 * @author motb
 * @date 2020/4/14 14:36
 * @description
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleEntity, RoleMapper> implements RoleService {
}

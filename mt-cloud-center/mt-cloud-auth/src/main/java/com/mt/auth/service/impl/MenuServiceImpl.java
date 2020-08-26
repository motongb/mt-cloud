package com.mt.auth.service.impl;

import com.mt.auth.dao.MenuMapper;
import com.mt.auth.service.MenuService;
import com.mt.common.core.base.BaseTreeServiceImpl;
import com.mt.common.entity.base.MenuEntity;
import org.springframework.stereotype.Service;

/**
 * @author motb
 * @date 2020/4/13 16:58
 * @description
 */
@Service
public class MenuServiceImpl extends BaseTreeServiceImpl<MenuEntity, MenuMapper> implements MenuService {
}

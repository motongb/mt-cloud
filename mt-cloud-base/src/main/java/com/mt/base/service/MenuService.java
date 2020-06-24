package com.mt.base.service;

import com.mt.base.dao.MenuMapper;
import com.mt.common.core.base.BaseTreeServiceImpl;
import com.mt.common.entity.base.MenuEntity;
import org.springframework.stereotype.Service;

/**
 * @auther: motb
 * @date: 2020/4/13 16:58
 * @description:
 */
@Service
public class MenuService extends BaseTreeServiceImpl<MenuEntity, MenuMapper> {
}

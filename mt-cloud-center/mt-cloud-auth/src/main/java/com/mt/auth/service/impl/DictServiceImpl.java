package com.mt.auth.service.impl;

import com.mt.auth.dao.DictMapper;
import com.mt.auth.service.DictService;
import com.mt.common.core.base.BaseTreeServiceImpl;
import com.mt.common.entity.auth.DictEntity;
import org.springframework.stereotype.Service;

/**
 * @author motb
 * @date 2020/5/12 16:39
 * @description
 */
@Service
public class DictServiceImpl extends BaseTreeServiceImpl<DictEntity, DictMapper> implements DictService {
}

package com.mt.common.core.base;

import com.mt.common.core.SysBaseMapper;

import java.util.List;

/**
 * @author motb
 * @date 2020/8/26 10:12
 * @description //TODO BaseTreeService
 **/
public interface BaseTreeService<T extends BaseTreeEntity, M extends SysBaseMapper<T>> extends BaseService<T, M> {

    List<T> tree();
}

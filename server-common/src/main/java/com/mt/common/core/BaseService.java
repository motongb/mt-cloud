package com.mt.common.core;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: motb
 * @Date: 2020/4/9 15:32
 * @Description:
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 新增修改
     *
     * @param t
     * @return
     */
    T saveOrUpdate(T t);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(List<Long> ids);

    /**
     * @param example
     * @return
     */
    List<T> listByExample(Example example);
}

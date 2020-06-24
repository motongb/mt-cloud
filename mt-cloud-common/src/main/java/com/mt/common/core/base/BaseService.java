package com.mt.common.core.base;

import com.mt.common.core.PageResult;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: motb
 * @Date: 2020/4/9 15:32
 * @Description:
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 新增
     *
     * @param t
     * @return
     */
    T save(T t);

    /**
     * 编辑
     *
     * @param t
     * @return
     */
    T update(T t);

    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(List<Long> ids);

    /**
     * 参数查询
     *
     * @param example
     * @return
     */
    List<T> listByExample(Example example);

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param example
     * @return
     */
    PageResult<T> listByPage(Integer pageNum, Integer pageSize, Object example);
}

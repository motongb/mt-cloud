package com.mt.common.core.base;

import com.mt.common.core.PageResult;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author motb
 * @date 2020/4/9 15:32
 * @description
 */
public interface BaseService<T, M> {
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
     * 条件删除
     *
     * @param t
     */
    int delete(T t);

    /**
     * 参数查询
     *
     * @param example
     * @return
     */
    List<T> listByExample(Example example);

    /**
     * 分页查询,需要实现mapper.xml方法
     *
     * @param pageNum
     * @param pageSize
     * @param t
     * @return
     */
    PageResult<T> listByPage(Integer pageNum, Integer pageSize, T t);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 获取mapper
     *
     * @return
     */
    M getBaseMapper();
}

package com.mt.common.core.base;

import com.github.pagehelper.PageHelper;
import com.mt.common.core.PageResult;
import com.mt.common.core.SysBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author motb
 * @date 2020/4/9 15:37
 * @description
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseEntity, M extends SysBaseMapper<T>> implements BaseService<T, M> {

    @Autowired
    private M baseMapper;

    @Override
    public T save(T t) {
        baseMapper.insertSelective(t);
        return t;
    }

    @Override
    public T update(T t) {
        baseMapper.updateByPrimaryKeySelective(t);
        return t;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        baseMapper.deleteByIdList(ids);
    }

    @Override
    public int delete(T t) {
        return baseMapper.delete(t);
    }

    @Override
    public List<T> listByExample(Example example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public PageResult<T> listByPage(Integer pageNum, Integer pageSize, T t) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> result = baseMapper.selectByList(t);
        return PageResult.paresPage(result);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public M getBaseMapper() {
        return baseMapper;
    }
}

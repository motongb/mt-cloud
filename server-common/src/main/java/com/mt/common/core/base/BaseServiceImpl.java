package com.mt.common.core.base;

import com.github.pagehelper.PageHelper;
import com.mt.common.core.PageResult;
import com.mt.common.core.SysBaseMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: motb
 * @Date: 2020/4/9 15:37
 * @Description:
 */
@Slf4j
@Getter
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity, M extends SysBaseMapper<T>> implements BaseService<T> {

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
    public List<T> listByExample(Example example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public PageResult<T> listByPage(Integer pageNum, Integer pageSize, Object example) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> result = baseMapper.selectByExample(example);
        return PageResult.paresPage(result);
    }

    public static Logger getLog() {
        return log;
    }
}

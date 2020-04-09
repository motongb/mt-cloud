package com.mt.common.core;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;

/**
 * @Auther: motb
 * @Date: 2020/4/9 15:37
 * @Description:
 */
@Getter
public abstract class BaseServiceImpl<T extends BaseEntity, M extends SysBaseMapper<T>> implements BaseService<T> {

    @Autowired
    private SysBaseMapper baseMapper;

    @Override
    public T saveOrUpdate(T t) {
        if (Objects.isNull(t.getId())) {
            baseMapper.insertSelective(t);
        } else {
            baseMapper.updateByPrimaryKeySelective(t);
        }
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
}

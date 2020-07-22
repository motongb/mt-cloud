package com.mt.book.service;

import com.github.pagehelper.PageHelper;
import com.mt.api.base.feign.FileApi;
import com.mt.book.dao.BookMapper;
import com.mt.common.core.PageResult;
import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.book.BookEntity;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/27 17:19
 * @description:
 */
@Service
public class BookService extends BaseServiceImpl<BookEntity, BookMapper> {

    @Autowired
    private FileApi fileApi;

    @Override
    @GlobalTransactional
    public BookEntity save(BookEntity bookEntity) {
        getBaseMapper().insertSelective(bookEntity);
        if (!CollectionUtils.isEmpty(bookEntity.getFiles())) {
            handleFiles(bookEntity);
        }
        return bookEntity;
    }

    /**
     * 保存文件
     *
     * @param bookEntity
     */
    private void handleFiles(BookEntity bookEntity) {
        bookEntity.getFiles().forEach(file -> file.setRelateId(bookEntity.getId()));
        fileApi.save(bookEntity.getFiles());
    }

    @Override
    public PageResult<BookEntity> listByPage(Integer pageNum, Integer pageSize, Object example) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookEntity> result = getBaseMapper().selectByList((BookEntity) example);
        return PageResult.paresPage(result);
    }
}

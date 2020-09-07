package com.mt.middle.service.impl;

import com.mt.common.core.base.BaseServiceImpl;
import com.mt.common.entity.middle.BookEntity;
import com.mt.middle.dao.BookMapper;
import com.mt.middle.service.BookService;
import com.mt.middle.service.FileService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author motb
 * @date 2020/4/27 17:19
 * @description
 */
@Service
@AllArgsConstructor
public class BookServiceImpl extends BaseServiceImpl<BookEntity, BookMapper> implements BookService {

    private FileService fileService;

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
        fileService.getBaseMapper().insertList(bookEntity.getFiles());
    }
}

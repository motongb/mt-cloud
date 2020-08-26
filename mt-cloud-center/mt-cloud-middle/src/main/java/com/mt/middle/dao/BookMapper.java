package com.mt.middle.dao;

import com.mt.common.core.SysBaseMapper;
import com.mt.common.entity.book.BookEntity;

import java.util.List;

/**
 * @author motb
 * @date 2020/4/27 17:18
 * @description
 */
public interface BookMapper extends SysBaseMapper<BookEntity> {

    List<BookEntity> selectByList(BookEntity bookEntity);
}

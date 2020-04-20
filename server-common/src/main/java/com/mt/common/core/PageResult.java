package com.mt.common.core;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/17 11:27
 * @description: 分页类
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private List<T> data;

    private PageResult() {
    }

    public static <T> PageResult paresPage(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getResult());
        }
        return new PageResult<>();
    }
}

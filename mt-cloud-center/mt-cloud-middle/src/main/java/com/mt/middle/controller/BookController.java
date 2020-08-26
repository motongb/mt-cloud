package com.mt.middle.controller;

import com.mt.common.entity.book.BookEntity;
import com.mt.common.http.HttpResult;
import com.mt.middle.service.BookService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author motb
 * @date 2020/4/27 17:20
 * @description
 */
@Api(tags = "图书管理-书本管理")
@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping
    public HttpResult page(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           BookEntity bookEntity) {
        return HttpResult.success(bookService.listByPage(pageNum, pageSize, bookEntity));
    }

    @PostMapping
    public HttpResult save(@RequestBody BookEntity bookEntity) {
        bookService.save(bookEntity);
        return HttpResult.success();
    }
}

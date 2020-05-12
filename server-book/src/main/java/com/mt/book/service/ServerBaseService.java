package com.mt.book.service;

import com.mt.common.entity.base.FileEntity;
import com.mt.common.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/27 16:56
 * @description:
 */
@FeignClient(value = "server-base")
public interface ServerBaseService {

    @PostMapping("/sys/file")
    HttpResult save(@RequestBody List<FileEntity> fileEntityList);
}

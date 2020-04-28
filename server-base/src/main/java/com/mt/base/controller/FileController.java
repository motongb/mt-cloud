package com.mt.base.controller;

import com.mt.base.service.FileService;
import com.mt.common.entity.base.FileEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/27 17:02
 * @description:
 */
@Api(tags = "系统-文件管理")
@RestController
@RequestMapping("/sys/file")
@AllArgsConstructor
public class FileController {

    private FileService fileService;

    @ApiOperation("批量插入")
    @PostMapping
    public HttpResult save(@RequestBody List<FileEntity> fileEntityList) {
        fileService.saveList(fileEntityList);
        return HttpResult.success();
    }

    @ApiOperation("批量删除")
    @DeleteMapping
    public HttpResult batchDelete(@RequestBody List<Long> ids) {
        fileService.batchDelete(ids);
        return HttpResult.success();
    }
}

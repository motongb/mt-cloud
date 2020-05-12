package com.mt.base.controller;

import com.mt.base.service.DictService;
import com.mt.common.entity.base.DictEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/5/12 16:40
 * @description:
 */
@Api(tags = "系统-字典管理")
@RestController
@AllArgsConstructor
@RequestMapping("/sys/dict")
public class DictController {

    private DictService dictService;

    @ApiOperation("获取字典列表")
    @GetMapping
    public HttpResult tree() {
        return HttpResult.success(dictService.tree());
    }

    @ApiOperation("新增")
    @PostMapping
    public HttpResult save(@RequestBody DictEntity dictEntity) {
        dictService.save(dictEntity);
        return HttpResult.success();
    }

    @ApiOperation("编辑")
    @PutMapping
    public HttpResult update(@RequestBody DictEntity dictEntity) {
        dictService.update(dictEntity);
        return HttpResult.success();
    }

    @ApiOperation("删除")
    @DeleteMapping
    public HttpResult batchDelete(List<Long> ids) {
        dictService.batchDelete(ids);
        return HttpResult.success();
    }
}

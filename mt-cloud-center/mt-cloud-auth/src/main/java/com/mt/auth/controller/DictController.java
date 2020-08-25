package com.mt.auth.controller;

import com.mt.auth.service.DictService;
import com.mt.common.entity.base.DictEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

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

    @ApiOperation("查询")
    @GetMapping
    public HttpResult get(@RequestParam(required = false) @ApiParam("父id") String parentId,
                          @RequestParam(defaultValue = "true") @ApiParam("是否父级") Boolean isParent) {
        Example example = new Example(DictEntity.class);
        if (isParent) {
            example.and().andIsNull("parentTreeId");
        } else {
            example.and().andEqualTo("parentTreeId", parentId);
        }
        return HttpResult.success(dictService.listByExample(example));
    }

    @ApiOperation("获取字典列表")
    @GetMapping("/tree")
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
    public HttpResult batchDelete(@RequestBody List<Long> ids) {
        dictService.batchDelete(ids);
        return HttpResult.success();
    }
}

package com.mt.base.controller;

import com.mt.base.service.MenuService;
import com.mt.common.entity.sys.MenuEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/14 08:55
 * @description:
 */
@Api(tags = "系统-菜单")
@RestController
@RequestMapping("/sys/menu")
@AllArgsConstructor
public class MenuController {

    private MenuService menuService;

    @PostMapping
    public HttpResult save(@RequestBody MenuEntity menuEntity) {
        menuService.save(menuEntity);
        return HttpResult.success();
    }

    @PutMapping
    public HttpResult update(@RequestBody MenuEntity menuEntity) {
        Assert.notNull(menuEntity.getId(), "require id");
        menuService.update(menuEntity);
        return HttpResult.success();
    }

    @GetMapping
    public HttpResult tree() {
        return HttpResult.success(menuService.tree());
    }

    @DeleteMapping
    public HttpResult batchDelete(@RequestBody List<Long> ids) {
        menuService.batchDelete(ids);
        return HttpResult.success();
    }
}

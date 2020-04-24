package com.mt.base.controller;

import com.mt.base.service.RoleService;
import com.mt.common.entity.sys.RoleEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/14 14:38
 * @description:
 */
@Api(tags = "系统-角色")
@RestController
@RequestMapping("/sys/role")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public HttpResult get() {
        return HttpResult.success(roleService.getBaseMapper().selectAll());
    }

    @PostMapping
    public HttpResult save(@RequestBody RoleEntity roleEntity) {
        roleService.save(roleEntity);
        return HttpResult.success();
    }

    @PutMapping
    public HttpResult update(@RequestBody RoleEntity roleEntity) {
        roleService.update(roleEntity);
        return HttpResult.success();
    }

    @DeleteMapping
    public HttpResult batchDelete(@RequestBody List<Long> ids) {
        return HttpResult.success();
    }
}

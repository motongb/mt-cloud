package com.mt.auth.controller;

import com.mt.auth.service.UserRelRoleService;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther: motb
 * @date: 2020/4/17 09:23
 * @description:
 */
@Api(tags = "系统-角色用户")
@RestController
@RequestMapping("/sys/user/role")
@AllArgsConstructor
public class UserRelRoleController {

    private UserRelRoleService userRelRoleService;

    @ApiOperation("保存")
    @PostMapping("/{roleId}")
    public HttpResult save(@PathVariable @ApiParam("角色id") Long roleId,
                           @RequestBody List<Long> userIds) {
        userRelRoleService.saveList(roleId, userIds);
        return HttpResult.success();
    }

    @ApiOperation("已关联用户")
    @GetMapping("/{roleId}")
    public HttpResult relUser(@PathVariable @ApiParam("角色id") Long roleId) {
        return HttpResult.success(userRelRoleService.getBaseMapper().selectByRoleId(roleId));
    }

}

package com.mt.provide2.controller;

import com.mt.common.core.UserContext;
import com.mt.common.entity.sys.UserEntity;
import com.mt.common.http.HttpResult;
import com.mt.provide2.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author motb
 * @date 2020/3/25 17:42
 * @description:
 */
@Api(tags = "系统-用户")
@RestController
@RequestMapping("/sys/user")
@AllArgsConstructor
public class UserController {


    UserService userService;

    @GetMapping
    public HttpResult info() {
        return HttpResult.success(UserContext.getContext());
    }

    @PostMapping
    public HttpResult save(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
        return HttpResult.success();
    }

    @PutMapping
    public HttpResult update(@RequestBody UserEntity userEntity) {
        userService.update(userEntity);
        return HttpResult.success();
    }

    @DeleteMapping
    public HttpResult batchDelete(@RequestBody List<Long> ids) {
        userService.batchDelete(ids);
        return HttpResult.success();
    }

    @GetMapping("/list")
    public HttpResult list() {
        Example example = new Example(UserEntity.class);
        return HttpResult.success(userService.listByExample(example));
    }
}

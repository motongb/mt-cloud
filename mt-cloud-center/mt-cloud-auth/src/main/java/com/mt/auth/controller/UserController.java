package com.mt.auth.controller;

import com.mt.auth.service.UserService;
import com.mt.common.entity.base.UserEntity;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    public HttpResult register(@RequestBody UserEntity userEntity) {
        userService.register(userEntity);
        return HttpResult.success();
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

    @GetMapping("/page")
    public HttpResult page(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           UserEntity userEntity) {
        return HttpResult.success(userService.listByPage(pageNum, pageSize, userEntity));
    }
}

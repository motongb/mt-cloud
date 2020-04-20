package com.mt.base.controller;

import com.mt.common.core.UserContext;
import com.mt.common.entity.vo.LoginInfo;
import com.mt.common.http.HttpResult;
import com.mt.base.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: motb
 * @date: 2020/4/9 16:40
 * @description:
 */
@Api(tags = "系统-登录")
@RestController
@RequestMapping("/sys")
@AllArgsConstructor
public class LoginController {

    LoginService loginService;

    @GetMapping("/info")
    public HttpResult info() {
        return HttpResult.success(UserContext.getContext());
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginInfo loginInfo) {
        return HttpResult.success(loginService.login(loginInfo));
    }
}

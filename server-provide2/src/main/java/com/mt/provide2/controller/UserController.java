package com.mt.provide2.controller;

import com.mt.common.core.UserContext;
import com.mt.common.entity.vo.LoginInfo;
import com.mt.common.http.HttpResult;
import com.mt.provide2.service.LoginService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author motb
 * @date 2020/3/25 17:42
 * @description:
 */
@Api(tags = "User Controller")
@RestController
@AllArgsConstructor
public class UserController {

    LoginService loginService;

    @PostMapping("login")
    public HttpResult login(@RequestBody LoginInfo loginInfo) {
        return HttpResult.success(loginService.login(loginInfo));
    }

    @GetMapping("info")
    public HttpResult info() {
        return HttpResult.success(UserContext.getContext());
    }
}

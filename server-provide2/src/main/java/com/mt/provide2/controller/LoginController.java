package com.mt.provide2.controller;

import com.mt.common.entity.vo.LoginInfo;
import com.mt.common.http.HttpResult;
import com.mt.provide2.service.LoginService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: motb
 * @date: 2020/4/9 16:40
 * @description:
 */
@Api(tags = "Login Controller")
@RestController
@RequestMapping("/sys")
@AllArgsConstructor
public class LoginController {

    LoginService loginService;

    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginInfo loginInfo) {
        return HttpResult.success(loginService.login(loginInfo));
    }
}

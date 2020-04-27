package com.mt.base.controller;

import com.mt.base.service.EmailService;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: motb
 * @date: 2020/4/24 14:46
 * @description:
 */
@Api(tags = "系统-邮箱管理")
@RestController
@AllArgsConstructor
@RequestMapping("/sys/mail")
public class EmailController {

    private EmailService emailService;

    @GetMapping("/code/{email}")
    public HttpResult sendCode(@PathVariable String email) {
        return HttpResult.success(emailService.sendValidCode(email));
    }

    @GetMapping("/valid-code")
    public HttpResult validCode(@RequestParam String email, @RequestParam String validCode) {
        Assert.isTrue(emailService.checkValidCode(email, validCode), "验证码失效");
        return HttpResult.success();
    }
}

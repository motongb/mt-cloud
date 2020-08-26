package com.mt.middle.controller;

import com.mt.common.http.HttpResult;
import com.mt.middle.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author motb
 * @date 2020/4/24 14:46
 * @description
 */
@Api(tags = "邮箱管理")
@RestController
@AllArgsConstructor
@RequestMapping("/sys/mail")
public class EmailController {

    private EmailService emailService;

    @ApiOperation("发送验证码")
    @GetMapping("/code/{email}")
    public HttpResult sendCode(@PathVariable String email) {
        return HttpResult.success(emailService.sendValidCode(email));
    }

    @ApiOperation("校验验证码")
    @GetMapping("/valid-code")
    public HttpResult validCode(@RequestParam String email, @RequestParam String validCode) {
        Assert.isTrue(emailService.checkValidCode(email, validCode), "验证码失效");
        return HttpResult.success();
    }
}

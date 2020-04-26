package com.mt.base.controller;

import com.mt.base.service.EmailService;
import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String code = emailService.createValidCode(6);
        emailService.sendSimpleMail(email, "验证码", code);
        return HttpResult.success(code);
    }
}

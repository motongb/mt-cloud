package com.mt.base.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @auther: motb
 * @date: 2020/4/24 14:45
 * @description:
 */
@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    private Map<String, String> mailCodeMap = new HashMap<>();

    private static final String CODE_LIST = "23456789QWERTYUIOPASDFGHJKLZXCVBNM";

    /**
     * 简单内容
     *
     * @param to
     * @param subject
     * @param content
     */
    @Async
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        //发送邮件
//        javaMailSender.send(message);
        log.info("发送邮件===={}", content);
    }

    /**
     * 创建验证码
     *
     * @param codeLong
     * @return
     */
    public String createValidCode(int codeLong) {
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();
        int start = 0;
        while (start < codeLong) {
            int index = random.ints(0, 34).limit(1).findFirst().getAsInt();
            codeBuilder.append(CODE_LIST.charAt(index));
            start++;
        }
        return codeBuilder.toString();
    }
}

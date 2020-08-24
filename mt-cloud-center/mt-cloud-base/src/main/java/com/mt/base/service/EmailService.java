package com.mt.base.service;

import com.mt.common.entity.base.vo.ValidCodeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: motb
 * @date: 2020/4/24 14:45
 * @description:
 */
@Slf4j
@Service
public class EmailService {

    private static final String CODE_LIST = "23456789QWERTYUIOPASDFGHJKLZXCVBNM";
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    private Map<String, ValidCodeVo> cacheMailCodeMap = new ConcurrentHashMap<>();

    /**
     * 简单内容
     *
     * @param to
     * @param subject
     * @param content
     * @return
     */

    /***@Async**/
    public String sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //发送邮件
//        javaMailSender.send(message);
        log.info("发送邮件===={}", content);
        return content;
    }

    /**
     * 发送验证码
     *
     * @param to
     * @return
     */
    public String sendValidCode(String to) {
        String code = createValidCode(6);
        CompletableFuture.supplyAsync(() -> sendSimpleMail(to, "验证码", code)).thenAccept(res -> {
            ValidCodeVo codeVo = new ValidCodeVo();
            codeVo.setStartTime(System.currentTimeMillis());
            codeVo.setValidCode(res);
            cacheMailCodeMap.put(to, codeVo);
            log.info("缓存{}", res);
        });
        return code;
    }

    /**
     * 验证邮箱验证码
     *
     * @param email
     * @param code
     * @return
     */
    public boolean checkValidCode(String email, String code) {
        ValidCodeVo codeVo = cacheMailCodeMap.get(email);
        if (codeVo == null) {
            return false;
        }
        return code.equals(codeVo.getValidCode());
    }


    /**
     * 创建验证码
     *
     * @param codeLong
     * @return
     */
    private String createValidCode(int codeLong) {
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

    /**
     * 定时清理缓存
     */
    @Scheduled(fixedDelay = 15 * 1000)
    private void clearCache() {
        Iterator<Map.Entry<String, ValidCodeVo>> iterator = cacheMailCodeMap.entrySet().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        while (iterator.hasNext()) {
            ValidCodeVo codeVo = iterator.next().getValue();
            if (currentTimeMillis - codeVo.getStartTime() > codeVo.getExpire()) {
                iterator.remove();
                log.info("清理验证码{}", codeVo.getValidCode());
            }
        }
    }
}

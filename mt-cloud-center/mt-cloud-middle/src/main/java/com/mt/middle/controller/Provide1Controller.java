package com.mt.middle.controller;

import com.mt.common.http.HttpResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author motb
 * @date 2020/3/26 0:26
 * @description:
 */
@Api(tags = "Provide1 Controller")
@RestController
public class Provide1Controller {

    @GetMapping("client1")
    public HttpResult provide1() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return HttpResult.success("client1 success");
    }
}

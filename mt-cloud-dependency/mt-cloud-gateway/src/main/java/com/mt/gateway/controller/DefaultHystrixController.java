package com.mt.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultFallback")
    public Mono<String> handle() {
        return Mono.just("Server is business");
    }
}

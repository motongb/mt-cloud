package com.mt.provide1;

import com.mt.common.annotation.EnableSysException;
import com.mt.common.annotation.EnableSysSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableSysSwagger2
@EnableSysException
@EnableEurekaClient
@SpringBootApplication
public class Provide1Application {

    public static void main(String[] args) {
        SpringApplication.run(Provide1Application.class, args);
    }

}

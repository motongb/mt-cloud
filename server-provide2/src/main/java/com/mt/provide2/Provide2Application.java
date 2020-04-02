package com.mt.provide2;

import com.mt.common.annotation.EnableSysException;
import com.mt.common.annotation.EnableSysSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableSysException
@EnableSysSwagger2
@EnableEurekaClient
@SpringBootApplication
public class Provide2Application {

    public static void main(String[] args) {
        SpringApplication.run(Provide2Application.class, args);
    }

}

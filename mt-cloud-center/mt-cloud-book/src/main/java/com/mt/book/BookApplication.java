package com.mt.book;

import com.mt.common.annotation.EnableOpenFeign;
import com.mt.common.annotation.EnableTokenAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableTokenAuth
@EnableEurekaClient
@SpringBootApplication
@EnableOpenFeign
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

}

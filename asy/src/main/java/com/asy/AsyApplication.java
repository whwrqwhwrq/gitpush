package com.asy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
//开启异步注解
@EnableAsync
@SpringBootApplication
public class AsyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyApplication.class, args);
    }

}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时任务的注解
@SpringBootApplication
public class TimertaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimertaskApplication.class, args);
    }

}

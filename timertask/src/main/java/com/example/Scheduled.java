package com.example;

import org.springframework.stereotype.Service;

@Service
public class Scheduled {
    //在一个特定的时间执行这个方法
    //@org.springframework.scheduling.annotation.Scheduled(cron = "0 0/1 22 * * ?")
    @org.springframework.scheduling.annotation.Scheduled(cron = "0/3 * * * * ?")
    public void hello() {
        System.out.println("你好，");
    }
}

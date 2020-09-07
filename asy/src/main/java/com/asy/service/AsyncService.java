package com.asy.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async
    public void hello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("程序正在处理");
    }

}

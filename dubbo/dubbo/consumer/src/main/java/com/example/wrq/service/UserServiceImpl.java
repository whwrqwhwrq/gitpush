package com.example.wrq.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class UserServiceImpl implements UserService{
    @DubboReference
    WrqService wrqService;
    @Override
    public String fetch(String name) {
        String s = wrqService.get();
        return name+"拿到了"+s;
    }
}

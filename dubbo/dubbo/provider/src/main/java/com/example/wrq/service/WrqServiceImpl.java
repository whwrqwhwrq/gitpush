package com.example.wrq.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
//服务注册与发现
@DubboService
@Component//使用dubbo后尽量不要使用@Service注解(但2.7.7以后dubbo的service注解变为了dubboService)
public class WrqServiceImpl implements WrqService {

    @Override
    public String get() {
        return "midnight";
    }
}

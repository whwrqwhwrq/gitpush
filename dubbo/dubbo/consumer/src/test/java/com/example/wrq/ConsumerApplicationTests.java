package com.example.wrq;

import com.example.wrq.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        String jedar = userService.fetch("jedar");
        System.out.println(jedar);
    }

}

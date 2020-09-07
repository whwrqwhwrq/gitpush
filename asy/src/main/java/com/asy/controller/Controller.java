package com.asy.controller;

import com.asy.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    AsyncService asyncService;
    @Autowired
    JavaMailSenderImpl mailSender;
    @ResponseBody
    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        asyncService.hello();
        return "hello";
    }
@GetMapping("/")
    public String toIndex() {
        return "index";
    }
    @GetMapping("/send")
    @ResponseBody
    public String send(String title,String desc ,String from,String to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(desc);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(from);
        try {
            mailSender.send(simpleMailMessage);
        } catch (MailException e) {
            return "发送失败";
        }
        return "发送成功";
    }
}

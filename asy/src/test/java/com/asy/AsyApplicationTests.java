package com.asy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class AsyApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //简单的邮件发送
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("测试邮件，jedar0k");
        simpleMailMessage.setText("测试一下邮件任务");
        simpleMailMessage.setTo("814822472@qq.com");
        simpleMailMessage.setFrom("843110539@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    void ComplexMail() throws MessagingException {
        //复杂的邮件任务
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("这是一封本机 寄出的复杂邮件");
        mimeMessageHelper.setText("<p style='color:red'>正在学习中</p>",true);
        File file1 = new File("C:\\Users\\jedar0k\\Desktop\\重要网址.txt");
        File file2 = new File("C:\\Users\\jedar0k\\Desktop\\新建文本文档.txt");
        mimeMessageHelper.addAttachment("重要网址.txt",file1);
        mimeMessageHelper.addAttachment("新建文本文档.txt",file2);
        mimeMessageHelper.setFrom("843110539@qq.com");
        mimeMessageHelper.setTo("814822472@qq.com");
        mailSender.send(mimeMessage);
    }
}

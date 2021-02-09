package com.example.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 定时任务测试
 * @Author:wrq
 * @Date:2020/11/13 14:42
 */
@Component
public class ScheduleDemo {
    @Scheduled(cron = "0/6 59 * * * ?")
    public void scheduleTest() {

        LocalDateTime now = LocalDateTime.now();
        String dateStr = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日   HH:mm:ss"));
        String res = String.format(("定时任务开启，当前时间：%s"), dateStr);
        System.out.println(res);

    }
}

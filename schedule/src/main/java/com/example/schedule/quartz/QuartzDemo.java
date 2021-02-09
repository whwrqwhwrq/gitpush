package com.example.schedule.quartz;

import com.example.schedule.service.IUserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author:wrq
 * @Date:2020/11/16 11:05
 */
public class QuartzDemo implements Job {
    @Autowired
    private IUserService userService;
    //任务被触发时所执行的方法
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        String dateStr = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日  HH:mm:ss"));
        String res = String.format(("定时任务开启，当前时间：%s"), dateStr);
        System.out.println(res);
        userService.addUser();
    }
}

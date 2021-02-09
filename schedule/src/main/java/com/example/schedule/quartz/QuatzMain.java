package com.example.schedule.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author:wrq
 * @Date:2020/11/16 11:07
 */
public class QuatzMain {
    public static void main(String[] args) throws SchedulerException {
        //1 创建job对象
        JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class).build();
        //2 创建trigger（触发器）对象
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

        //3 创建scheduler对象
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.scheduleJob(jobDetail, cronTrigger);

        defaultScheduler.start();
    }

}

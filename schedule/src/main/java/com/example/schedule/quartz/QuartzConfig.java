package com.example.schedule.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @Author:wrq
 * @Date:2020/11/16 14:35
 */
@Configuration
public class QuartzConfig {
    @Autowired
    private MyAdaptableJobFactory myAdaptableJobFactory;

    @Bean
    public JobDetailFactoryBean getJobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(QuartzDemo.class);
        return jobDetailFactoryBean;
    }
    @Bean
    public SimpleTriggerFactoryBean getSimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        simpleTriggerFactoryBean.setRepeatInterval(3000);
        simpleTriggerFactoryBean.setRepeatCount(100);
        return simpleTriggerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean getCronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return cronTriggerFactoryBean;
    }
    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());

        schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);

        return schedulerFactoryBean;
    }
}

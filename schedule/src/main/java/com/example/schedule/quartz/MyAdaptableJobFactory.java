package com.example.schedule.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author:wrq
 * @Date:2020/11/16 15:00
 */
@Component("my")
public class MyAdaptableJobFactory extends AdaptableJobFactory {
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}

package com.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

/**
 * Created by jylee on 2017-06-08.
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Bean
    public ScheduledExecutorFactoryBean scheduledExecutorService() {
        ScheduledExecutorFactoryBean bean = new ScheduledExecutorFactoryBean();
        bean.setPoolSize(1);
        return bean;
    }
}

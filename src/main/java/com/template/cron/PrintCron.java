package com.template.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jylee on 2017-06-08.
 */
@Component
public class PrintCron {
//    2:20 start 3 hour increase
//    @Scheduled(cron = "0 20 2/3 * * *")
//    public void aJob() {
//        // do something
//    }

    @Scheduled(cron ="* */1 * * * *")
    public void cronPrintJob() {
        System.out.println("cron print job!");
    }

    @Scheduled(fixedRate = 5000)
    public void fixedRateprintJob() {
        System.out.println("fixedRate print job!");
    }
}

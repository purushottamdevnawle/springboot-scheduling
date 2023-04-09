package com.playground.springboot.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void fixedRateScheduling() {
        log.info("Fixed Rate - The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayScheduling() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Fixed Delay - The time is now {}", dateFormat.format(new Date()));
    }
}

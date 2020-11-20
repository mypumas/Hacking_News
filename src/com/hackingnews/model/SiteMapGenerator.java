package com.hackingnews.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
public class SiteMapGenerator implements ServletContextListener {
 
    private ScheduledExecutorService scheduler;
 
    @Override
    public void contextInitialized(ServletContextEvent event) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable command = new MailThread(event.getServletContext());
        // Delay 1 Minute to first execution
        long initialDelay = 1;
        TimeUnit unit = TimeUnit.MINUTES;
        // period the period between successive executions
        long period = 200;// 60 Minute!
 
        scheduler.scheduleAtFixedRate(command, initialDelay, period, unit);
    }
 
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }
 
}
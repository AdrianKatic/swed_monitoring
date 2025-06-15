package com.adrian.monitoring.service;

import com.adrian.monitoring.model.Subscription;
import com.adrian.monitoring.notifier.Notifier;
import com.adrian.monitoring.notifier.NotifierFactory;
import com.adrian.monitoring.notifier.NotifierObserver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitoringService {
    private final SubscriptionManager mgr;
    private final ScheduledExecutorService exec = Executors.newScheduledThreadPool(4);

    public MonitoringService(SubscriptionManager mgr) {
        this.mgr = mgr;
    }

    public void startAll() {
        for (Subscription s : mgr.all()) {
            try {
                WebsiteMonitor monitor = new WebsiteMonitor(s.url());

                Notifier notifier = NotifierFactory.get(s.config().getChannel());
                NotifierObserver observer = new NotifierObserver(s.user(), notifier);

                monitor.addObserver(observer);

                long period = s.config().getFrequency().toMinutes();
                exec.scheduleAtFixedRate(() -> {
                    try {
                        monitor.check();
                    } catch (Exception e) {
                        notifier.send(
                                s.user(),
                                "Error checking " + s.url() + ": " + e.getMessage()
                        );
                    }
                }, 0, period, TimeUnit.MINUTES);

            } catch (Exception e) {

            }
        }
    }
}

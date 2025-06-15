package com.adrian.monitoring;

import com.adrian.monitoring.model.*;
import com.adrian.monitoring.service.SubscriptionManager;
import com.adrian.monitoring.service.MonitoringService;

public class Main {
    public static void main(String[] args) {
// User
        User adrian = new User(1, "Adrian", "adrian@gmail.com","Adr1an!");
// Build subscription manager
        SubscriptionManager mgr = new SubscriptionManager();
// Adrian subscribes to example.com every 1 min via Console
        mgr.add(new Subscription(adrian,
                "example.com",
                new NotificationConfig(Frequency.MIN_1, NotificationChannel.CONSOLE)));
        new MonitoringService(mgr).startAll();
    }
}

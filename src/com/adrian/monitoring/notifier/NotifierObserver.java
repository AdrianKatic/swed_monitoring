package com.adrian.monitoring.notifier;

import com.adrian.monitoring.model.User;
import com.adrian.monitoring.service.MonitorObserver;
import com.adrian.monitoring.service.WebsiteMonitor;

public class NotifierObserver implements MonitorObserver {
    private final User user;
    private final Notifier notifier;

    public NotifierObserver(User user, Notifier notifier) {
        this.user     = user;
        this.notifier = notifier;
    }

    @Override
    public void update(WebsiteMonitor subject) {
        notifier.send(user, "Update detected at " + subject.getUrl());
    }
}

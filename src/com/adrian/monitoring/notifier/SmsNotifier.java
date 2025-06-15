package com.adrian.monitoring.notifier;

import com.adrian.monitoring.model.User;

public class SmsNotifier implements Notifier {
    @Override
    public void send(User user, String message) {
        System.out.printf("[SMS ->%s] %s%n", user.getUsername(), message);
    }
}

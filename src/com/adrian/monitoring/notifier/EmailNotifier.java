package com.adrian.monitoring.notifier;

import com.adrian.monitoring.model.User;

public class EmailNotifier implements Notifier {
    @Override
    public void send(User user, String message) {
        System.out.printf("[Email ->%s] %s%n", user.getUsername(), message);
    }
}

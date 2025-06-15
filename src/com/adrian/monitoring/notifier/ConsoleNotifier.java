package com.adrian.monitoring.notifier;

import com.adrian.monitoring.model.User;

public class ConsoleNotifier implements Notifier {
    @Override
    public void send(User user, String message) {
        System.out.printf("[Console ->%s] %s%n", user.getUsername(), message);
    }
}

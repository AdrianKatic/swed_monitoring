package com.adrian.monitoring.notifier;

import com.adrian.monitoring.model.User;

public interface Notifier {
    void send(User user, String message);
}

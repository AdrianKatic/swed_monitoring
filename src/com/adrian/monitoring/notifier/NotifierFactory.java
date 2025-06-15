package com.adrian.monitoring.notifier;

import com.adrian.monitoring.model.NotificationChannel;

public class NotifierFactory {
    public static Notifier get(NotificationChannel channel) {
        return switch (channel) {
            case CONSOLE -> new ConsoleNotifier();
            case EMAIL -> new EmailNotifier();
            case SMS -> new SmsNotifier();
        };
    }
}

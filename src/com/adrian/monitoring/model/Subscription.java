package com.adrian.monitoring.model;

public record Subscription (
        User user,
        String url,
        NotificationConfig config
) {

    public Subscription {
        if (user == null) throw new IllegalArgumentException("user required");
        if (url == null || url.isBlank()) throw new IllegalArgumentException("url required");
        if (config == null) throw new IllegalArgumentException("config required");
    }

}

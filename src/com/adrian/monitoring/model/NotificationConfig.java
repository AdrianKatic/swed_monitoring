package com.adrian.monitoring.model;

public class NotificationConfig {

    private Frequency frequency;
    private NotificationChannel channel;

    public NotificationConfig(Frequency frequency, NotificationChannel channel) {
        if (frequency == null) throw new IllegalArgumentException("frequency required");
        if (channel == null)   throw new IllegalArgumentException("channel required");
        this.frequency = frequency;
        this.channel   = channel;
    }
    public Frequency getFrequency()           { return frequency; }
    public NotificationChannel getChannel()   { return channel;    }

    public void setFrequency(Frequency f)     { frequency = f; }
    public void setChannel(NotificationChannel c) { channel = c; }

}

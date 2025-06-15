package com.adrian.monitoring.model;

public enum Frequency {
    MIN_1(1),
    MIN_5(5),
    MIN_30(30),
    HOURLY(60),
    DAILY(1_440);

    private final int minutes;
    Frequency(int minutes) { this.minutes = minutes; }
    public int toMinutes()  { return minutes; }
}

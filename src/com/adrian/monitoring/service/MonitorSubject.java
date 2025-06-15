package com.adrian.monitoring.service;

public interface MonitorSubject {
    void addObserver(MonitorObserver o);
    void removeObserver(MonitorObserver o);
}

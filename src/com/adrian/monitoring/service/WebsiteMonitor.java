package com.adrian.monitoring.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WebsiteMonitor implements MonitorSubject{
    private final String url;
    private String lastHash = null;

    private final List<MonitorObserver> observers = new CopyOnWriteArrayList<>();

    public WebsiteMonitor(String url) {
        this.url = url;
    }

    public void check() throws Exception {
        String content = fetch();
        String hash    = sha256(content);

        if (lastHash == null) {
            lastHash = hash;
        } else if (!lastHash.equals(hash)) {
            lastHash = hash;
            notifyObservers();
        }
    }

    private String fetch() throws Exception {
        StringBuilder sb = new StringBuilder();
        URI uri = URI.create(url);
        URL u   = uri.toURL();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()))) {
            String line;
            while ((line = in.readLine()) != null) sb.append(line);
        }
        return sb.toString();
    }

    private String sha256(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[]       b  = md.digest(input.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte x : b) hex.append(String.format("%02x", x));
        return hex.toString();
    }
    public String getUrl() {
        return url;
    }

    @Override
    public void addObserver(MonitorObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(MonitorObserver o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (MonitorObserver o : observers) {
            o.update(this);
        }
    }
}

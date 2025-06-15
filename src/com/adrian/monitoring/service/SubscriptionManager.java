package com.adrian.monitoring.service;
import com.adrian.monitoring.model.Subscription;

import java.util.*;

public class SubscriptionManager {
    private final Map<Integer, List<Subscription>> subs = new HashMap<>();

    public void add(Subscription s) {
        subs.computeIfAbsent(s.user().getId(), k -> new ArrayList<>())
                .add(s);
    }

    public void remove(int userId, String url) {
        List<Subscription> list = subs.get(userId);
        if (list != null) {
            list.removeIf(s -> s.url().equals(url));
        }
    }

    public List<Subscription> forUser(int userId) {
        return subs.getOrDefault(userId, Collections.emptyList());
    }

    public Collection<Subscription> all() {
        List<Subscription> all = new ArrayList<>();
        subs.values().forEach(all::addAll);
        return all;
    }
}

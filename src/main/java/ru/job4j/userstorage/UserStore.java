package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.ref.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class UserStore {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();

    public synchronized boolean add(User user) {
        return true;
    }

    public synchronized boolean update(User user) {
        return true;
    }

    public synchronized boolean delete(User user) {
        return true;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        return true;
    }
}

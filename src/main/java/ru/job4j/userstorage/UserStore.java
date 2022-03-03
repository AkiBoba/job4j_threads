package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.ref.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class UserStore {
    static final Object LOCK = new Object();
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();

    public boolean add(User user) {
        synchronized (LOCK) {
            return true;
        }
    }

    public boolean update(User user) {
        synchronized (LOCK) {
            return true;
        }
    }

    public boolean delete(User user) {
        synchronized (LOCK) {
            return true;
        }
    }

    public boolean transfer(int fromId, int toId, int amount) {
        synchronized (LOCK) {
            return true;
        }
    }
}

package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class UserStore {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    public boolean add(User user) {
        return users.putIfAbsent(user.getId(), user) == null;
    }

    public boolean update(User user) {
         return users.put(user.getId(), user) != null;
    }

    public boolean delete(User user) {
         return user.equals(users.remove(user.getId()));
    }

    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User userFrom = users.get(fromId);
        User userTo = users.get(toId);
        if (userFrom != null && userTo != null && userFrom.getAmount() >= amount) {
            users.get(fromId).setAmount(userFrom.getAmount() - amount);
            users.get(toId).setAmount(userTo.getAmount() + amount);
            result = true;
        }
        return result;
    }
}

package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class UserStore {
    static final Object LOCK = new Object();
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    public UserStore() {
    }

    public boolean add(User user) {
            boolean result = false;
            if (!users.containsValue(user)) {
                users.put(user.getId(), user);
                result = true;
            }
            return result;
    }

    public boolean update(User user) {
        synchronized (LOCK) {
            boolean result = false;
            if (users.containsKey(user.getId())) {
                users.replace(user.getId(), user);
                result = true;
            }
            return result;
        }
    }

    public boolean delete(User user) {
        synchronized (LOCK) {
            boolean result = false;
            if (users.containsKey(user.getId())) {
                users.remove(user.getId());
                result = true;
            }
            return result;
        }
    }

    public boolean transfer(int fromId, int toId, int amount) {
        synchronized (LOCK) {
            validate(fromId, toId, amount);
            int fromAmount = users.get(fromId).getAmount();
            int toAmount = users.get(toId).getAmount();
            users.get(fromId).setAmount(fromAmount - amount);
            users.get(toId).setAmount(toAmount + amount);
            return true;
        }
    }

    private void validate(int fromId, int toId, int amount) {
        if (!(users.containsKey(fromId) && users.containsKey(toId) && users.get(fromId).getAmount() >= amount)) {
            throw new IllegalArgumentException("Проверьте еще раз переданные данные для транзакции");
        }
    }
}

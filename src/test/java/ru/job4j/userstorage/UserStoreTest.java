package ru.job4j.userstorage;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void add() {
        User user = new User(0, 200);
        UserStore userStore = new UserStore();
        userStore.add(user);
    }

    @Test
    public void update() {
    }
}
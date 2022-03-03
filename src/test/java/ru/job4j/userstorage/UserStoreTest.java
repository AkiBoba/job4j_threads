package ru.job4j.userstorage;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void addTest() {
        User user = new User(0, 200);
        UserStore userStore = new UserStore();
        assertTrue(userStore.add(user));
    }

    @Test
    public void updateTest() {
        User user = new User(0, 200);
        UserStore userStore = new UserStore();
        userStore.add(user);
        assertTrue(userStore.update(new User(0, 300)));
    }

    @Test
    public void deleteTest() {
        User user = new User(0, 200);
        UserStore userStore = new UserStore();
        userStore.add(user);
        assertTrue(userStore.delete(user));
    }

    @Test
    public void transferTest() {
        User userfrom = new User(0, 200);
        User userto = new User(1, 100);
        UserStore userStore = new UserStore();
        userStore.add(userfrom);
        userStore.add(userto);
        userStore.transfer(0, 1, 100);
        assertThat(userto.getAmount(), is(200));
    }
}
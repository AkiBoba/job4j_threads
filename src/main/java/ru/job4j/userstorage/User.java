package ru.job4j.userstorage;

public class User {
    private int id = 0;
    private volatile int amount;

    public User(int amount) {
        this.amount = amount;
        this.id++;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

}

package ru.job4j.exe;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    static ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    String subject;
    String body;

    public void notification(List<User> users) {
        pool.submit(() -> users.forEach(user -> emailTo(user)));
    }

    public void emailTo(User user) {
        subject = String.format("Notification %s to email %s.", user.getUsername(), user.getEmail());
        body = String.format("Add a new event to %s", user.getUsername());
        send(subject, body, user.getEmail());
    }

    public void  close() {
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String subject, String body, String email) {

    }
}

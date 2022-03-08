package ru.job4j.exe;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void notification(List<User> users) {
        pool.submit(() -> users.forEach(this::emailTo));
    }

    public void emailTo(User user) {
        String subject = String.format("Notification %s to email %s.", user.getUsername(), user.getEmail());
        String body = String.format("Add a new event to %s", user.getUsername());
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

    public static void main(String[] args) {
        EmailNotification emailNotification = new EmailNotification();
        User user = new User("Petr", "petr@mail.com");
        emailNotification.emailTo(user);
        emailNotification.close();
    }
}

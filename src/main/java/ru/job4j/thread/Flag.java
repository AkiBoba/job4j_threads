package ru.job4j.thread;

public class Flag {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    while (flag) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        thread.start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1500);
        flag = false;
        thread.join();
    }
}

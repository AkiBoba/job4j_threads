package ru.job4j.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutSRV {
    private final int size = Runtime.getRuntime().availableProcessors();
    ExecutorService pool = Executors.newFixedThreadPool(size
    );

    public void add(Runnable runnable) {
        System.out.println("add is run");
        pool.submit(runnable);
        System.out.println("add is stop");
    }

    public void close() {
        System.out.println("close is run");
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Execute " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutSRV executSRV = new ExecutSRV();
        Thread thread1 = new Thread(
                () -> System.out.println("Execute run " + Thread.currentThread().getName())
        );
        executSRV.add(thread1);
        System.out.println(thread1.getState());
        executSRV.close();
        thread1.join();
        Thread.sleep(2000);
        System.out.println(thread1.getState());
    }
}

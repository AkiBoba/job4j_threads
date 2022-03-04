package ru.job4j.wait;

public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public void count() {
        synchronized (monitor) {
            count++;
            monitor.notifyAll();
        }
    }

    public void await() {
        synchronized (monitor) {
            while (count < total) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        int total = 10;
        CountBarrier countBarrier = new CountBarrier(total);
        Thread count = new Thread(
                () -> {

                    for (int i = 1; i <= total; i++) {
                        System.out.println("count++");
                        countBarrier.count();
                    }
                }
        );
        Thread waiting = new Thread(
                () -> {
                    countBarrier.await();
                    System.out.println("Waiting off");
                }
        );
        count.start();
        waiting.start();
    }
}
package ru.job4j.queue;

import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        int total = 10;
        SimpleBlockingQueue<String> sbq = new SimpleBlockingQueue<>(total);
        Thread consumer = new Thread(
                () -> {
                    for (int i = 0; i < total + 25; i++) {
                        try {
                            sbq.poll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        Thread producer = new Thread(
                () -> {
                    for (int i = 0; i < total + 25; i++) {
                        try {
                            sbq.offer("value");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        producer.join();
    }
}
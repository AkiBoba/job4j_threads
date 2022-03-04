package ru.job4j.queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private final int total;

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public SimpleBlockingQueue(int total) {
        this.total = total;
    }

    public synchronized void offer(T value) {
        while (queue.size() >= total) {
            System.out.println("Очередь переполнена, ожидайте");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Очередь свободна для пополнения");
        queue.add(value);
        notify();
    }

    public synchronized T poll() {
        while (queue.isEmpty()) {
            System.out.println("Очередь пуста, ожидайте");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Вы можете получить объект из очереди");
        notify();
        return queue.poll();
    }

    public static void main(String[] args) throws InterruptedException {
        int total = 10;
        SimpleBlockingQueue<String> sbq = new SimpleBlockingQueue<>(total);
        Thread consumer = new Thread(
                () -> {
                    for (int i = 0; i < total + 25; i++) {
                        sbq.poll();
                    }
                }
        );

        Thread producer = new Thread(
                () -> {
                    for (int i = 0; i < total + 25; i++) {
                        sbq.offer("value");
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        producer.join();
    }
}

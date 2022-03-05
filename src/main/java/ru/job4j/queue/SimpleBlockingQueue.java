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

    public synchronized void offer(T value) throws InterruptedException {
        while (queue.size() >= total) {
            System.out.println("Очередь переполнена, ожидайте");
                wait();
        }
        System.out.println("Очередь свободна для пополнения");
        queue.add(value);
        notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Очередь пуста, ожидайте");
                wait();
        }
        System.out.println("Вы можете получить объект из очереди");
        T poll = queue.poll();
        notify();
        return poll;
    }

}

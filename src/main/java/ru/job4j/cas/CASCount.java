package ru.job4j.cas;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count =
            new AtomicReference<>(0);

    public void increment() {
        Integer temp = count.get();
        int newCount;
        do {
            newCount = temp++;
            System.out.println(temp);
        } while (!count.compareAndSet(temp, newCount));
        throw new UnsupportedOperationException("Count is not impl.");
    }

    public int get() {
        return count.get();
    }

    public static void main(String[] args) {
        CASCount casCount = new CASCount();
        casCount.increment();
    }
}

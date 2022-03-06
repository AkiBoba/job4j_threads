package ru.job4j.cas;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count =
            new AtomicReference<>();

    public void increment() {
        Integer temp;
        do {
            temp = count.get();
            System.out.println(temp);
        } while (!count.compareAndSet(temp, temp++));
        throw new UnsupportedOperationException("Count is not impl.");
    }

    public int get() {
        return count.get();
    }

    public static void main(String[] args) {
        CASCount
    }
}

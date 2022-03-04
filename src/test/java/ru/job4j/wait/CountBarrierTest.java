package ru.job4j.wait;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountBarrierTest {

    @Test
    public void count() {
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
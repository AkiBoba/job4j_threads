package ru.job4j.cas;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
public class CASCountTest {

    @Test
    public void increment2times() throws InterruptedException {
        CASCount casCount = new CASCount();
        Thread thread1 = new Thread(
                casCount::increment
        );
        Thread thread2 = new Thread(
                casCount::increment
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(casCount.get(), is(2));
    }

    @Test
    public void increment11times() throws InterruptedException {
        CASCount casCount = new CASCount();
        Thread thread1 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        casCount.increment();
                    }
                }
        );
        Thread thread2 = new Thread(
                casCount::increment
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(casCount.get(), is(11));

    }

}
package ru.job4j.cas;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
public class CASCountTest {

    @Test
    public void increment3times() {
        CASCount casCount = new CASCount();
        casCount.increment();
        casCount.increment();
        casCount.increment();
        assertThat(casCount.get(), is(3));
    }

    @Test
    public void increment10times() {
        CASCount casCount = new CASCount();
        for (int i = 0; i < 10; i++) {
            casCount.increment();
        }
        assertThat(casCount.get(), is(10));

    }

}
package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void when1And10Then30() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));

    }
}
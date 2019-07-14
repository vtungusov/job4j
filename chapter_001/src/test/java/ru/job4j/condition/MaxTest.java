package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then2() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To3Then3() {
        Max max = new Max();
        int result = max.max(3, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax3x2x1Then3() {
        Max max = new Max();
        int result = max.max(3, 2, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax1x2x5x5Then5() {
        Max max = new Max();
        int result = max.max(1, 2, 5, 5);
        assertThat(result, is(5));
    }
}
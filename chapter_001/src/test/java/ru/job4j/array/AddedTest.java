package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class AddedTest {
    @Test
    public void mergeT1() {
        int[] m1 = {1, 3, 5, 7, 8, 9};
        int[] m2 = {2, 3, 4};
        int[] expect = {1, 2, 3, 3, 4, 5, 7, 8, 9};
        int[] result = Added.merge(m1, m2);
        assertThat(result, is(expect));

    }

    @Test
    public void mergeT2() {
        int[] m2 = {1, 3, 5, 7, 8, 9};
        int[] m1 = {2, 3, 4};
        int[] expect = {1, 2, 3, 3, 4, 5, 7, 8, 9};
        int[] result = Added.merge(m1, m2);
        assertThat(result, is(expect));

    }

    @Test
    public void mergeT3() {
        int[] m1 = {1, 3, 5};
        int[] m2 = {2, 3, 4};
        int[] expect = {1, 2, 3, 3, 4, 5};
        int[] result = Added.merge(m1, m2);
        assertThat(result, is(expect));

    }
}
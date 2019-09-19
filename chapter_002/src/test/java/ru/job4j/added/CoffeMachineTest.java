package ru.job4j.added;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CoffeMachineTest {

    @Test
    public void changesTest() {
        CoffeMachine cf = new CoffeMachine();
        int[] result = cf.changes(50, 2);
        int[] expect = {10, 10, 10, 10, 5, 2, 1};
        assertThat(result, is(expect));
    }

}
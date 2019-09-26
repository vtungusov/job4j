package ru.job4j.added;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public void sortAcs() {
        String[] data = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",

                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };

        String[] result = Department.sortAsc(data);
        String[] expect = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",

                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        assertThat(result, is(expect));
    }

    @Test
    public void sortDesc() {
        String[] data = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",

                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
        };

        String[] result = Department.sortDesc(data);
        String[] expect = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",

                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
        };
        assertThat(result, is(expect));
    }
}
package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void convert() {
        List<int[]> list = new ArrayList<>();
        ConvertList2Array convertList2Array = new ConvertList2Array();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> expect = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            expect.add(i);
        }
        List<Integer> result = convertList2Array.convert(list);
        assertThat(result, is(expect));


    }
}
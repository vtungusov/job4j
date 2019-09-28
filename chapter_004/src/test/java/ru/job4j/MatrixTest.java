package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    Integer[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    @Test
    public void convertToList() {
        List<Integer> expect = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            expect.add(i);
        }
        assertThat(Matrix.convertToList(matrix), is(expect));
    }
}
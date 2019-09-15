package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InlineFunctionTest {
    public InlineFunction function;

    @Before
    public void setUp() {
        function = new InlineFunction();
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadroFunctionThenQuadroResults() {
        List<Double> result = function.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        List<Double> result = function.diapason(10, 11, x -> Math.log10(x) + 1);
        List<Double> expected = Arrays.asList(2D);
        assertThat(result, is(expected));
    }
}
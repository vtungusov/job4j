package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest  {
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenOneSubtractOneThenZero()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(1D, 1D);
        double expected = 0D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenNineDivTreeThenTree()  {
        Calculator calc = new Calculator();
        double result = calc.div(9D, 3D);
        double expected = 3D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenTwoMultiplyTreeThenSix()  {
        Calculator calc = new Calculator();
        double result = calc.multiply(2D, 3D);
        double expected = 6D;
        assertThat(result, is(expected));
    }
}
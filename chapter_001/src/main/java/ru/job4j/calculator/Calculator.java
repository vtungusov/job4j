package ru.job4j.calculator;

/**
 * Calculate.
 *
 * @author Vasily Tungusov (vtungusov@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * Method add.
     *
     * @param first  - first number.
     * @param second - second number.
     * @return sum of numbers
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Method add.
     *
     * @param first  - first number.
     * @param second - second number.
     * @param third  - third number.
     * @return sum of numbers
     */
    public double add(double first, double second, double third) {
        return add(
                first,
                add(second, third)
        );
    }

    /**
     * Method subtract.
     *
     * @param first  - first number.
     * @param second - second number.
     * @return difference of numbers
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Method div.
     *
     * @param first  - first number.
     * @param second - second number.
     * @return quotient of numbers
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Method multiply.
     *
     * @param first  - first number.
     * @param second - second number.
     * @return product of numbers
     */
    public double multiply(double first, double second) {
        return first * second;
    }
}
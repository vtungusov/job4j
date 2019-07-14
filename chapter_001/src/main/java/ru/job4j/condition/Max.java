package ru.job4j.condition;

/**
 * @author Vasily Tungusov
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Находит максимум из двух чисел
     *
     * @param left  первое число
     * @param right второе число
     * @return максимальное число
     */
    public int max(int left, int right) {
        return left >= right ? left : right;
    }

    /**
     * Находит максимум из трех чисел
     *
     * @param first  первое число
     * @param second второе число
     * @param third  третье число
     * @return максимальное число
     */
    public int max(int first, int second, int third) {
        return this.max(first, this.max(second, third));
    }

    /**
     * Находит максимум из четырех чисел
     *
     * @param first  первое число
     * @param second второе число
     * @param third  третье число
     * @param four   четвертое число
     * @return максимальное число
     */
    public int max(int first, int second, int third, int four) {
        return this.max(this.max(first, second), this.max(third, four));
    }
}
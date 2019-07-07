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
     * @param left первое число
     * @param right второе число
     * @return максимальное число
     */
    public int max(int left, int right) {
        int result = left >= right ? left : right;
        return result;
    }
}
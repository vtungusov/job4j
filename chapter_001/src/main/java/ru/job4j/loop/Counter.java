package ru.job4j.loop;

/**
 * @author Vasily Tungusov
 * @version 1.0
 * @since 8.07.19
 */
public class Counter {
    /**
     * Считает сумму четных чисел в заданном интервале
     *
     * @param start  начальное число
     * @param finish конечное число
     * @return сумма чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
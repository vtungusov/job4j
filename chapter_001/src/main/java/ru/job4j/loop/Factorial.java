package ru.job4j.loop;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Factorial {

    /**
     * Считает факториал числа
     * @param n целое положительное число
     * @return факториал исходного числа
     */
    public int calc(int n) {
        int result = 1;
//        if (n == 0)
//            result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
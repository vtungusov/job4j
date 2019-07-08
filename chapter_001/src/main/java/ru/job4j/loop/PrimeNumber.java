package ru.job4j.loop;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class PrimeNumber {

    /**
     * Считает количество простых чисел от 1 до finish
     *
     * @param finish конец интервала
     * @return количество простых чисел
     */
    public int calc(int finish) {
        int count = 0;
        loop: for (int i = 2; i <= finish; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    continue loop;
            }
            count++;
        }
        return count;
    }
}
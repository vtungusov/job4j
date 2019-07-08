package ru.job4j.array;

/**
 * @author Vasily Tunsuov
 * @version 1.0
 */
public class Square {

    /**
     * Заполняет массив числами, возведенными в квадрат
     *
     * @param bound Размерность массива
     * @return заполненный массив чисел
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (int) Math.pow((i + 1), 2);
        }
        return rst;
    }
}
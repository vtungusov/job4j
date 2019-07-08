package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Turn {

    /**
     * Инвертирует порядок элементов в массиве
     *
     * @param array массив данных
     * @return инвертированный массив
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        return array;
    }
}
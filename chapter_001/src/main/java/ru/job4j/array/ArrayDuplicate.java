package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int dupCount = 0;

        /*Поиск дубликата в массиве*/
        for (int i = 0; i < array.length; i++)
            for (int j = 1 + i; j < array.length - dupCount; j++)
                if (array[i].equals(array[j])) {

                    /*Смещение дубликата в конец массива*/
                    for (int k = j; k < array.length - 1 - dupCount; k++) {
                        String tmp = array[k];
                        array[k] = array[k + 1];
                        array[k + 1] = tmp;
                    }
                    dupCount++;
                }

        /*Отрезаем дубликаты от исходного массива*/
        array = Arrays.copyOf(array, array.length - dupCount);
        return array;
    }
}
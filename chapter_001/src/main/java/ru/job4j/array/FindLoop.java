package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class FindLoop {

    /**
     * Ищет индекс искомого элемента в массиве
     *
     * @param data Массив данных
     * @param el   Искомый элемент
     * @return индекс элемента
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Ищет индекс искомого элемента в диапазоне массива
     *
     * @param data   Массив данных
     * @param el     Искомый элемент
     * @param start  Индекс с которого начинаем поиск
     * @param finish Индекс которым заканчиваем поиск
     * @return индекс элемента
     */
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int index = start; index < finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Сортировка массива методом выбора
     *
     * @param data массив данных
     * @return отсортированный массив
     */
    public int[] sort(int[] data) {
        int limit = 0; //граница разделения отсортированной и не отсортированной частей
        int minIndex = 0; //индекс минимального значения массива

        while (limit < data.length) {

            /*
            ищем минимальное значение в неотсортированной части массива
            */
            for (int i = limit + 1; i < data.length; i++) {
                if (data[i] < data[minIndex]) {
                    minIndex = i;
                }
            }

            /*
            Переставляем минимальное знаечение в начало неотсортированной части
             */
            int tmp = data[limit];
            data[limit] = data[minIndex];
            data[minIndex] = tmp;

            /*
            Сдвигаем указатель отсортированной части
            и обнуляем minIndex
             */
            limit++;
            minIndex = limit;
        }
        return data;
    }
}
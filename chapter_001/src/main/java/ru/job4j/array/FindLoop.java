package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class FindLoop {

    /**
     * Ищит индекс искомого элемента в массиве
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
}
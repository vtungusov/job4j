package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Check {

    /**
     * Проверяет массив на идентичность значений
     *
     * @param data массив значений
     * @return результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean flag = data[0];
        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] != flag)
                result = false;
        }
        return result;
    }
}
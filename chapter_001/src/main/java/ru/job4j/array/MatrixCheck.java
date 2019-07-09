package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.2
 */
public class MatrixCheck {

    /**
     * проверяет матрицу на одинаковость значений по диагонали
     *
     * @param data исходная матрица
     * @return вердикт
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean dgn1Date = data[0][0];
        boolean dgn2Date = data[data.length - 1][0];

        for (int i = 0; i < data.length; i++)
            if ((data[i][i] != dgn1Date) ||
                    (data[data.length - 1 - i][i] != dgn2Date))
                result = false;
        return result;
    }
}
package ru.job4j.array;

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

        if (data.length % 2 == 0) {
            for (int i = 0; i < data.length - 1; i++) {
                if ((data[i][i] != dgn1Date) &&
                        (data[data.length - i][i] != dgn1Date))
                    result = false;
            }
        } else
            for (int i = 0; i < data.length - 1; i++) {
                if ((data[i][i] != dgn1Date) &&
                        (data[data.length - i][i] != dgn2Date))
                    result = false;
            }
        return result;
    }
}
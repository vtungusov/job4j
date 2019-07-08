package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Matrix {

    /**
     * Создает матрицу заданной размерности типа таблицы умножения
     *
     * @param size размерность матрицы
     * @return готовая матрица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
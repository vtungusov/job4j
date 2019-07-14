package ru.job4j.array;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Added {
    /**
     * Объединяет два упорядоченных массива, сохраняя сортировку
     *
     * @param m1 исходный сортированный массив
     * @param m2 исходный сортированный массив
     * @return результирующий массив
     */
    static int[] merge(int[] m1, int[] m2) {

        int[] result = new int[m1.length + m2.length];

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < result.length; i++) {

            if (p1 == m1.length) {
                System.arraycopy(m2, p2, result, i, m2.length - p2);
                break;
            }
            if (p2 == m2.length) {
                System.arraycopy(m1, p1, result, i, m1.length - p1);
                break;
            }


            if (m1[p1] <= m2[p2]) {
                result[i] = m1[p1];
                p1++;
            } else {
                result[i] = m2[p2];
                p2++;
            }
        }
        return result;
    }
}

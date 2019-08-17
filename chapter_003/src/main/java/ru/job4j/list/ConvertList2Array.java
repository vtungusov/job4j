package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                try {
                    array[i][j] = list.get(i * cells + j);
                } catch (ArrayIndexOutOfBoundsException e) {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
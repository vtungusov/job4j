package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int cell = 0;
        int row = 0;
        for (Integer integer : list) {
            if (cell != cells) {
                array[row][cell++] = integer;
            } else {
                cell = 0;
                array[++row][cell++] = integer;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ints : list) {
            for (int anInt : ints) {
                result.add(anInt);
            }
        }
        return result;
    }

}
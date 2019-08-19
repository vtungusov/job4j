package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] massL = left.toCharArray();
        char[] massR = right.toCharArray();
        int lim1 = massL.length;
        int lim2 = massR.length;

        int lim = Math.min(lim1, lim2);
        int result = lim1 - lim2;
        for (int i = 0; i < lim; i++) {
            if (massL[i] != massR[i]) {
                result = Character.compare(massL[i], massR[i]);
            }
        }
        return result;
    }
}

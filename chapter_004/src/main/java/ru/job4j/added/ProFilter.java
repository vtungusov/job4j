package ru.job4j.added;

import java.util.Arrays;

/**
 * @author Vasily Tungusov
 * @version 0.1
 */
public class ProFilter {
    /**
     * Generate sum of squared number in massiv with Stream API help
     *
     * @param mass initial mass
     * @return sum of squared number in massiv
     */
    public static Integer makeMagic(int[] mass) {
        return Arrays.stream(mass).filter(n -> n % 2 == 0).map(e -> (int) Math.pow(e, 2)).reduce(Integer::sum).orElse(0);
    }
}
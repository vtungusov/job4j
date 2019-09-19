package ru.job4j.added;

import java.util.ArrayList;
import java.util.List;

public class CoffeMachine {
    private final int[] COINS = {10, 5, 2, 1};

    int[] changes(int value, int price) {
        int change = value - price;
        List<Integer> list = new ArrayList<>();
        for (int coin : COINS) {
            int amount = change / coin;
            for (int i = 0; i < amount; i++) {
                list.add(coin);
                change -= coin;
            }
            if (change % coin == 0)
                break;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

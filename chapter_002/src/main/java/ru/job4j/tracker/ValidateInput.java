package ru.job4j.tracker;

import java.util.regex.Pattern;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    public String ask(String s) {
        return this.input.ask(s);
    }

    private boolean validate(String key, int[] range) {
        boolean result = true;
        if (!Pattern.matches("^[0-9]+$", key)) {
            System.out.println("Введите корректные данные");
            result = false;
        } else {
            int anInt = Integer.parseInt(key);
            boolean exist = false;
            for (int value : range) {
                if (anInt == value) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                result = false;
                System.out.println("Выберите номер из меню");
            }
        }
        return result;
    }

    public int ask(String question, int[] range) {
        String key;
        do {
            key = this.ask(question);
        }
        while (!validate(key, range));
        return Integer.parseInt(key);
    }
}
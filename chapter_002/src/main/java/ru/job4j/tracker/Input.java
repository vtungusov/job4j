package ru.job4j.tracker;

public interface Input {
    String ask(String s);

    int ask(String question, int[] range);

}

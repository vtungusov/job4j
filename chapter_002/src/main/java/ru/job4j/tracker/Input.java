package ru.job4j.tracker;

import java.util.List;

public interface Input {
    String ask(String s);

    int ask(String question, List<Integer> range);

}

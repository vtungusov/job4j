package ru.job4j.oop;

public enum Diagnose {
    HARD("To be, or not to be?"),
    NORM("Will be live."),
    EASY("Go home, dude!");

    private String verdict;

    Diagnose(String verdict) {
        this.verdict = verdict;
    }

    public String getVerdict() {
        return verdict;
    }

    @Override
    public String toString() {
        return "Diagnose{" +
                "verdict='" + verdict + '\'' +
                '}';
    }
}

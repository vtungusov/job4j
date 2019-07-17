package ru.job4j.oop;

public class Programmer extends Engineer {
    int projectScore;

    public Programmer() {
        super(10);
    }

    public Programmer(int projectScore) {
        super(10);
        this.projectScore = projectScore;
    }
}

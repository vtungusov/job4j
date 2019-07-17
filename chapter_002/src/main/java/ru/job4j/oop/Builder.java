package ru.job4j.oop;

public class Builder extends Engineer {
    int buildScore;

    public Builder() {
        super(10);
    }

    public Builder(int buildScore) {
        super(10);
        this.buildScore = buildScore;
    }
}

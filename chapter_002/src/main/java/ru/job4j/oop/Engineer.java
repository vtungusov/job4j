package ru.job4j.oop;

public class Engineer extends Profession {
    private int mastering;

    public Engineer(int mastering) {
        this.mastering = mastering;
    }

    public void impoveMastering() {
        this.mastering++;
    }

    public Thing create(int time) {
        int count = 0;
        for (int i = 0; i < time; i++) {
            count += this.mastering;
        }
        return new Thing(count);
    }
}

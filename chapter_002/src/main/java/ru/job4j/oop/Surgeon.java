package ru.job4j.oop;

public class Surgeon extends Doctor {
    int limbScore;

    public void cutLimb(Pacient p) {
        this.limbScore++;
        p.health += 10;
    }
}


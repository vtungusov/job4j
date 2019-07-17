package ru.job4j.oop;

public class Dentist extends Doctor {
    int toothScore;

    public void drainTooth(Pacient p) {
        this.toothScore++;
        p.health++;
    }

}

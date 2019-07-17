package ru.job4j.oop;

public class Doctor extends Profession {

    public Diagnose heal(Pacient pacient) {
        Diagnose result;
        if (pacient.health >= 80) result = Diagnose.EASY;
        else if (pacient.health >= 40) result = Diagnose.NORM;
        else result = Diagnose.HARD;

        return result;
    }

}

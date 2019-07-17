package ru.job4j.oop;

import java.util.Date;

public class Profession {
    private String name = "Valya";
    private String surname = "Pisunov";
    String education;
    Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public Date getBirthday() {
        return birthday;
    }
}

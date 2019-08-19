package ru.job4j.list;

import java.util.Objects;

public class User {
    private final int id;
    private String name, city;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

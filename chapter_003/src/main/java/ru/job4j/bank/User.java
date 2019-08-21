package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private String passport;

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public int compareTo(User o) {
        int result = this.passport.compareTo(o.passport);
        return result == 0 ? this.name.compareTo(o.name) : result;
    }
}
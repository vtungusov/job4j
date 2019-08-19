package ru.job4j.comparator;

public class User implements Comparable<User> {
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

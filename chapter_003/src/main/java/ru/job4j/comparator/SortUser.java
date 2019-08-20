package ru.job4j.comparator;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>(/*new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        }*/);
        set.addAll(list);
        return set;
    }

    public List<User> sortByNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        return list;
    }
}

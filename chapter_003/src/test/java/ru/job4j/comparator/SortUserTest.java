package ru.job4j.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
    @Test
    public void sort() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("ivan", 12),
                new User("vasily", 10),
                new User("petr", 15)
        ));
        List<User> expect = new ArrayList<>(Arrays.asList(
                new User("ivan", 12),
                new User("petr", 15),
                new User("vasily", 10)
        ));
        SortUser sortUser = new SortUser();
        TreeSet<User> result = (TreeSet<User>) sortUser.sort(users);

        assertThat(result.toString(), is(expect.toString()));
    }
}
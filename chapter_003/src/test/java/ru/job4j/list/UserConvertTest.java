package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void process() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "ivan"));
        userList.add(new User(2, "sergei"));
        Map<Integer, User> result = new UserConvert().process(userList);
        Map<Integer, User> expect = Map.ofEntries(
                entry(1, new User(1, "ivan")),
                entry(2, new User(2, "sergei"))
        );
        assertThat(result, is(expect));
    }
}
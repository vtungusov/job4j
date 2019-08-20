package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {
    @Test
    public void process() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "ivan"));
        userList.add(new User(2, "sergei"));
        HashMap<Integer, User> result = new UserConvert().process(userList);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "ivan"));
        expect.put(2, new User(2, "sergei"));
        assertThat(result, is(expect));
    }
}
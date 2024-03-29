package ru.job4j.travelCompany;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfileTest {
    List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("B", "Lenina", 412, 1000)));
        profiles.add(new Profile(new Address("B", "Lenina", 412, 1000)));
        profiles.add(new Profile(new Address("B", "Lenina", 412, 1000)));
        profiles.add(new Profile(new Address("A", "Kirova", 30, 400)));
        profiles.add(new Profile(new Address("C", "Frunze", 5, 22)));
    }

    @Test
    public void collect() {
        List<Address> expect = new ArrayList<>();
        expect.add(new Address("A", "Kirova", 30, 400));
        expect.add(new Address("B", "Lenina", 412, 1000));
        expect.add(new Address("C", "Frunze", 5, 22));

        assertThat(Profile.collect(profiles), is(expect));
    }
}
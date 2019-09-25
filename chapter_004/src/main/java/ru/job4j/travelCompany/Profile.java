package ru.job4j.travelCompany;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    public Profile(Address address) {
        this.address = address;
    }

    private Address address;

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(p -> p.address).collect(Collectors.toList());
    }
}
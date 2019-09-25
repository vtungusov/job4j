package ru.job4j.travelCompany;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Profile {
    public Profile(Address address) {
        this.address = address;
    }

    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> p.address)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
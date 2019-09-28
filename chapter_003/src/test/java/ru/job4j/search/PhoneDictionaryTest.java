package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var except = List.of(
                new Person("Petr", "Arsentev", "534872", "Bryansk"));
        assertThat(phones.find("Petr"), is(except));
    }
}

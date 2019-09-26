package ru.job4j.studentFiltering;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    Map<String, Student> convertToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(
                s -> s.surname,
                s -> s
        ));
    }

}

package ru.job4j.studentFiltering;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.stream.Stream;

public class School {

    List<Student> separateBy(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    Map<String, Student> convertToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(
                s -> s.surname,
                s -> s
        ));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.score > bound)
                .collect(Collectors.toList());
    }

}

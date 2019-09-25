package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SchoolTest {

    List<Student> studentsHeap = new ArrayList<>();

    @Before
    public void setUp() {
        studentsHeap.add(new Student(80));
        studentsHeap.add(new Student(60));
        studentsHeap.add(new Student(25));
    }

    @Test
    public void whenMaxScoreThen80() {
        School school = new School();
        List<Student> except = new ArrayList<>();
        except.add(new Student(80));

        List<Student> result = school.collect(studentsHeap, student ->
                70 <= student.score && student.score <= 100
        );

        assertThat(result, is(except));
    }

    @Test
    public void whenMaxScoreThen60() {
        School school = new School();
        List<Student> except = new ArrayList<>();
        except.add(new Student(60));

        List<Student> result = school.collect(studentsHeap, student ->
                50 <= student.score && student.score < 70
        );

        assertThat(result, is(except));
    }

    @Test
    public void whenMaxScoreThen25() {
        School school = new School();
        List<Student> except = new ArrayList<>();
        except.add(new Student(25));

        List<Student> result = school.collect(studentsHeap, student ->
                0 < student.score && student.score < 50
        );

        assertThat(result, is(except));
    }

}
package ru.job4j.studentFiltering;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    List<Student> studentsHeap = new ArrayList<>();
    School school;

    @Before
    public void setUp() {
        school = new School();
        studentsHeap.add(new Student("Ivanov", 80));
        studentsHeap.add(new Student("Petrov", 60));
        studentsHeap.add(new Student("Sidorov", 25));
    }

    @Test
    public void convertToMap() {
        Map<String, Student> except = new HashMap<>();
        except.put("Ivanov", new Student("Ivanov", 80));
        except.put("Petrov", new Student("Petrov", 60));
        except.put("Sidorov", new Student("Sidorov", 25));

        assertThat(school.convertToMap(studentsHeap), is(except));
    }

    @Test
    public void whenMaxScoreThen80() {
        List<Student> except = new ArrayList<>();
        except.add(new Student("Ivanov", 80));

        List<Student> result = school.separateBy(studentsHeap, student ->
                70 <= student.score && student.score <= 100
        );

        assertThat(result, is(except));
    }

    @Test
    public void whenMaxScoreThen60() {
        List<Student> except = new ArrayList<>();
        except.add(new Student("Petrov", 60));

        List<Student> result = school.separateBy(studentsHeap, student ->
                50 <= student.score && student.score < 70
        );

        assertThat(result, is(except));
    }

    @Test
    public void whenMaxScoreThen25() {
        List<Student> except = new ArrayList<>();
        except.add(new Student("Sidorov", 25));

        List<Student> result = school.separateBy(studentsHeap, student ->
                0 < student.score && student.score < 50
        );

        assertThat(result, is(except));
    }

    @Test
    public void levelOf() {
        List<Student> oneMore = new ArrayList<>();
        oneMore.add(new Student(90));
        oneMore.add(new Student(9));
        oneMore.add(new Student("Petrov", 86));
        oneMore.add(new Student("Kyskov", 40));
        oneMore.add(new Student("Daynov", 1));

        List<Student> except = new ArrayList<>();
        except.add(new Student(90));

        assertThat(school.levelOf(oneMore, 80), is(except));
    }
}
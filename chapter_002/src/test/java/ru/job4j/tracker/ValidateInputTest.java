package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class adapter for validate input data
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        List<Integer> list = new ArrayList<>();
        list.add(1);
        input.ask("Enter", list);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите корректные данные%n")
                )
        );
    }

    @Test
    public void whenInvalidInput2() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"222", "1"})
        );
        List<Integer> list = new ArrayList<>();
        list.add(1);
        input.ask("Enter", list);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Выберите номер из меню%n")
                )
        );
    }
}
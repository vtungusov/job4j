package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {
    private final PrintStream stdOut = new PrintStream(System.out);
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Paint paint = new Paint();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdOut);
    }

    @Test
    public void whenDrawSquare() {
        paint.draw(new Square());
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append("----------")
                        .append(System.lineSeparator())
                        .append("|        |")
                        .append(System.lineSeparator())
                        .append("|        |")
                        .append(System.lineSeparator())
                        .append("|        |")
                        .append(System.lineSeparator())
                        .append("----------")
                        .append(System.lineSeparator())
                        .toString()
        ));
    }

    @Test
    public void whenDrawTriangle() {
        paint.draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append("    ^     ")
                        .append(System.lineSeparator())
                        .append("  /   \\  ")
                        .append(System.lineSeparator())
                        .append(" /     \\ ")
                        .append(System.lineSeparator())
                        .append("- - - - -")
                        .append(System.lineSeparator())
                        .toString()
        ));
    }
}
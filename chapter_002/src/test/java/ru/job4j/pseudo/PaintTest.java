package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdOut = new PrintStream(System.out);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
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
        PrintStream stdOut = new PrintStream(System.out);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
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
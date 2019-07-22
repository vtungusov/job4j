package ru.job4j.pseudo;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Triangle implements Shape {

    /**
     * Возвращает строковое представление для треугольника
     *
     * @return строковое представление для треугольника
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    ^     ");
        pic.append(System.lineSeparator());
        pic.append("  /   \\  ");
        pic.append(System.lineSeparator());
        pic.append(" /     \\ ");
        pic.append(System.lineSeparator());
        pic.append("- - - - -");
        return pic.toString();
    }
}

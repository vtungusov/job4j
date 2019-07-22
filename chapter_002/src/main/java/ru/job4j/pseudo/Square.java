package ru.job4j.pseudo;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Square implements Shape {
    /**
     * Возвращает строковое представление для квадрата
     *
     * @return строковое представление для квадрата
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("----------");
        pic.append(System.lineSeparator());
        pic.append("|        |");
        pic.append(System.lineSeparator());
        pic.append("|        |");
        pic.append(System.lineSeparator());
        pic.append("|        |");
        pic.append(System.lineSeparator());
        pic.append("----------");
        return pic.toString();
    }
}

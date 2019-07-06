package ru.job4j.condition;

/**
 * Класс для вычисления расстояние между точками в системе координат
 *
 * @author Vasily Tungusov (vtungusov@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Point {

    /**
     * Method distance.
     * @param x1 x1 coordinate
     * @param x2 x2 coordinate
     * @param y1 y1 coordinate
     * @param y2 y2 coordinate
     * @return distance between dots.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}
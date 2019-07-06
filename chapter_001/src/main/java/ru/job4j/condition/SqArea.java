package ru.job4j.condition;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */
public class SqArea {

    /**
     * @param p Периметр прямоугольника
     * @param k отношение высоты прямоугольника к ширине
     * @return площадь прямоугольника
     */
    public int square(int p, int k) {
        int h = p / (2 * (k + 1));
        int w = h * k;
        return h * w;
    }
}
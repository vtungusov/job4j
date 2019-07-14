package ru.job4j.condition;

public class Triangle {

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return полуперимента.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.

     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return answer
     */
    private boolean exist(double a, double c, double b) {
        return (a < (b + c)) && (b < (a + c)) && (c < (a + b));
    }

    /**
     * Метод должен вычислить площадь треугольника.
     * <p>
     * Формула.
     * <p>
     * √ p *(p - a) * (p - b) * (p - c)
     * <p>
     * где √ - корень квадратный, для извлечения корня использован метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl = -1;
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
        return rsl;
    }
}
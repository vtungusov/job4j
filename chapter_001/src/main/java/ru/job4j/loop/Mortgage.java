package ru.job4j.loop;

/**
 * Класс для расчета кредита (без суммы за пользование кредитом)
 * не использовать в реальной жизни!
 *
 * @author Vasily Tungusov
 * @version 1.0
 */
public class Mortgage {

    /**
     * Расчитывает количество лет,
     * необходимых для погашения кредита
     *
     * @param amount  общая сумма кредита
     * @param monthly ежемесячный платеж
     * @param percent процент по кредиту
     * @return количество лет
     */
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double total = amount + amount * percent / 100;
        while (total > 0) {
            total -= 12 * monthly;
            year++;
        }
        return year;
    }
}
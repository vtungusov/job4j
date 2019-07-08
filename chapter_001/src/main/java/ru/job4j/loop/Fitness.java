package ru.job4j.loop;

/**
 * Класс для ЗОЖ-ников и диванных экспертов
 */
public class Fitness {

    /**
     * Считает через сколько месяцев Иван будет доминировать над Николой в тяге
     * @param ivan текущие показания Ивана в тяге
     * @param nik текущие показания Николы в тяге
     * @return количество месяцев
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while (nik > ivan) {
            ivan *= 3;
            nik *= 2;
            month++;
        }
        return month;
    }
}
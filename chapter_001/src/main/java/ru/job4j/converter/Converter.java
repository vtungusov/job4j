package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    private final int EURO = 70;
    private final int DOLLAR = 60;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / EURO;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / DOLLAR;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * EURO;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value Доллары
     * @return рубли
     */
    public int dollarToRuble(int value) {
        return value * DOLLAR;
    }
}
package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    public String ask(String s) {
        return this.input.ask(s);
    }

    public int ask(String question, int[] range) {
        int result = -1;
        boolean invalid = true;
        while (invalid) {
            try {
                result = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Введите корректные данные");
            } catch (MenuOutException e) {
                System.out.println("Выберите номер из меню");
            }
        }
        return result;
    }
}
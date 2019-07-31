package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        boolean invalid = true;
        while (invalid) {
            try {
                result = super.ask(question, range);
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
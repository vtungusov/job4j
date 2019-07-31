package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует работу меню
 *
 * @author Vasily Tungusov
 * @since 0.1
 */
public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения длины массива меню.
     *
     * @return длина массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + ", Name : " + item.getName() + ", Description : " + item.getDesc() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    private class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список существующих заявок: ------------");
            Item[] all = tracker.findAll();
            for (int i = 0; i < all.length; i++) {
                System.out.println(i + 1 + ". " + all[i].toString());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class UpdateItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование существующей заявки ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            boolean replace = tracker.replace(id, item);
            if (replace) {
                System.out.println("------------ Изменения успешно сохранены. ------------");
            } else {
                System.out.println("------------ Не удалось сохранить изменения. ------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) удаляемой заявки :");
            boolean delete = tracker.delete(id);
            if (delete) {
                System.out.println("------------ Заявка успешно удалена. ------------");
            } else {
                System.out.println("------------ Не удалось удалить заявку. ------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    private class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) искомой заявки :");
            Item item = tracker.findById(id);
            System.out.println("------------ Информация по искомой заявке : ------------");
            System.out.println(item);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }

    private class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени ------------");
            String name = input.ask("Введите имя искомой заявки :");
            Item[] items = tracker.findByName(name);
            System.out.println("------------ Информация по заявкам с именем " + name + " : ------------");
            for (int i = 0; i < items.length; i++) {
                System.out.println(i + 1 + ". " + items[i].toString());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    private class ExitProgram implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}

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

    public int[] getRanges() {
        int[] result = new int[this.getActionsLentgh()];
        int pointer = 0;
        for (UserAction action : actions) {
            result[pointer++] = action.key();
        }
        return result;
    }

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
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
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

    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
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
    }

    private class ShowItems extends BaseAction {

        protected ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список существующих заявок: ------------");
            Item[] all = tracker.findAll();
            for (int i = 0; i < all.length; i++) {
                System.out.println(i + 1 + ". " + all[i].toString());
            }
        }
    }

    private class UpdateItem extends BaseAction {

        protected UpdateItem(int key, String name) {
            super(key, name);
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
    }

    private class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
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
    }

    private class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) искомой заявки :");
            Item item = tracker.findById(id);
            System.out.println("------------ Информация по искомой заявке : ------------");
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    private class FindItemsByName extends BaseAction {

        protected FindItemsByName(int key, String name) {
            super(key, name);
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
    }

    private class ExitProgram extends BaseAction {

        protected ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.exit(0);
        }
    }
}

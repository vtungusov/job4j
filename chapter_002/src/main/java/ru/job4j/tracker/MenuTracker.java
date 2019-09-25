package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

    private final Consumer<String> output;

    public List<Integer> getRanges() {
        List<Integer> result = new ArrayList<>();
        int pointer = 0;
        for (UserAction action : actions) {
            result.add(action.key());
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
     * @param output  lambda
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения длины массива меню.
     *
     * @return длина массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program", ui));
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
        output.accept("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с Id : " + item.getId() + ", Name : " + item.getName() + ", Description : " + item.getDesc() + "-----------");
        }
    }

    private class ShowItems extends BaseAction {

        protected ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Список существующих заявок: ------------");
            List<Item> all = tracker.findAll();
            for (Item item : all) {
                output.accept(all.indexOf(item) + 1 + ". " + item.toString());
            }
        }
    }

    private class UpdateItem extends BaseAction {

        protected UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Редактирование существующей заявки ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            boolean replace = tracker.replace(id, item);
            if (replace) {
                output.accept("------------ Изменения успешно сохранены. ------------");
            } else {
                output.accept("------------ Не удалось сохранить изменения. ------------");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) удаляемой заявки :");
            boolean delete = tracker.delete(id);
            if (delete) {
                output.accept("------------ Заявка успешно удалена. ------------");
            } else {
                output.accept("------------ Не удалось удалить заявку. ------------");
            }
        }
    }

    private class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по ID ------------");
            String id = input.ask("Введите ID (уникальный идентификатор) искомой заявки :");
            Item item = tracker.findById(id);
            output.accept("------------ Информация по искомой заявке : ------------");
            if (item != null) {
                output.accept(item.toString());
            }
        }
    }

    private class FindItemsByName extends BaseAction {

        protected FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по имени ------------");
            String name = input.ask("Введите имя искомой заявки :");
            List<Item> items = tracker.findByName(name);
            output.accept("------------ Информация по заявкам с именем " + name + " : ------------");
            for (Item item : items) {
                output.accept(items.indexOf(item) + 1 + ". " + item.toString());
            }
        }
    }

    private class ExitProgram extends BaseAction {

        private final StartUI ui;

        protected ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }

}

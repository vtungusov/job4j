package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";


    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW_ALL:
                    this.showAllItem();
                    break;
                case EDIT:
                    this.edit();
                    break;
                case DELETE:
                    this.delete();
                    break;
                case FIND_BY_ID:
                    this.findItemByID();
                    break;
                case FIND_BY_NAME:
                    this.findItemByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
            }
        }
    }

    /**
     * Метод реализует поиск существующей заявки по имени
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени ------------");
        String name = this.input.ask("Введите имя искомой заявки :");
        Item[] items = tracker.findByName(name);
        System.out.println("------------ Информация по заявкам с именем " + name + " : ------------");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + 1 + ". " + items[i].toString());
        }
    }

    /**
     * Метод реализует поиск существующей заявки по ID
     */
    private void findItemByID() {
        System.out.println("------------ Поиск заявки по ID ------------");
        String id = this.input.ask("Введите ID (уникальный идентификатор) искомой заявки :");
        Item item = tracker.findById(id);
        System.out.println("------------ Информация по искомой заявке : ------------");
        System.out.println(item);
    }

    /**
     * Метод для удаления существующей заявки
     */
    private void delete() {
        System.out.println("------------ Удаление заявки ------------");
        String id = this.input.ask("Введите ID (уникальный идентификатор) удаляемой заявки :");
        boolean delete = tracker.delete(id);
        if (delete)
            System.out.println("------------ Заявка успешно удалена. ------------");
        else
            System.out.println("------------ Не удалось удалить заявку. ------------");

    }

    /**
     * Метод для редактирования существующей заявки
     */
    private void edit() {
        System.out.println("------------ Редактирование существующей заявки ------------");
        String id = this.input.ask("Введите ID (уникальный идентификатор) заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        boolean replace = tracker.replace(id, item);
        if (replace)
            System.out.println("------------ Изменения успешно сохранены. ------------");
        else
            System.out.println("------------ Не удалось сохранить изменения. ------------");
    }

    /**
     * Метод реализует отображение всех заявок в хранилище
     */
    private void showAllItem() {
        System.out.println("------------ Список существующих заявок: ------------");
        Item[] all = this.tracker.findAll();
        for (int i = 0; i < all.length; i++) {
            System.out.println(i + 1 + ". " + all[i].toString());
        }
    }

    /**
     * Метод реализует добавленяи новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод отображает пункты меню
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
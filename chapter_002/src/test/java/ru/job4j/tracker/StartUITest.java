package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stnOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String ls = System.lineSeparator();
    private final String menu = (new StringJoiner(ls)
            .add("Меню.")
            .add("0. Add new Item")
            .add("1. Show all items")
            .add("2. Edit item")
            .add("3. Delete item")
            .add("4. Find item by Id")
            .add("5. Find items by name")
            .add("6. Exit Program")).toString();

    @Before
    public void setOut() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void revertOut() {
        System.setOut(this.stnOut);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerHasNotItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenUserShowAllThenShowAllItem() {
        Tracker tracker = new Tracker();
        Item add = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String ls = System.lineSeparator();
        StringJoiner except = new StringJoiner(ls, "", ls);
        except
                .add(menu)
                .add("------------ Список существующих заявок: ------------")
                .add("1. Item{id='" + add.getId() + "', name='test name', decs='desc', time=0}")
                .add(menu);
        assertThat(out.toString(), is(except.toString()));
    }

    @Test
    public void whenFindByIdThenShowItem() {
        Tracker tracker = new Tracker();
        String ls = System.lineSeparator();
        Item add = tracker.add(new Item("name by id", "desc by id"));
        Input input = new StubInput(new String[]{"4", add.getId(), "6"});
        new StartUI(input, tracker).init();

        StringJoiner except = new StringJoiner(ls);
        except
                .add(menu)
                .add("------------ Поиск заявки по ID ------------")
                .add("------------ Информация по искомой заявке : ------------")
                .add("Item{id='" + add.getId() + "', name='" + add.getName() + "', decs='" + add.getDecs() + "', time=0}")
                .add(menu);
        assertThat(out.toString().trim(), is(except.toString()));
    }

    @Test
    public void whenFindByNameThenShowItem() {
        Tracker tracker = new Tracker();
        String ls = System.lineSeparator();
        Item add = tracker.add(new Item("name by name", "desc by name"));
        Input input = new StubInput(new String[]{"5", add.getName(), "6"});
        new StartUI(input, tracker).init();

        StringJoiner except = new StringJoiner(ls);
        except
                .add(menu)
                .add("------------ Поиск заявки по имени ------------")
                .add("------------ Информация по заявкам с именем " + add.getName() + " : ------------")
                .add("1. Item{id='" + add.getId() + "', name='" + add.getName() + "', decs='" + add.getDecs() + "', time=0}")
                .add(menu);
        assertThat(out.toString().trim(), is(except.toString()));
    }

}
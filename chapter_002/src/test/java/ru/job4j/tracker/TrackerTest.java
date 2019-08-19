package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "before item", 555L);
        Item itemDelete = new Item("Delete", "Delete item", 666L);
        Item item3 = new Item("item3", "after item", 777L);
        tracker.add(item1);
        tracker.add(itemDelete);
        tracker.add(item3);
        boolean res1 = tracker.delete(itemDelete.getId());
        List<Item> all = tracker.findAll();
        Item res2 = tracker.findById(itemDelete.getId());
        boolean result = res1 && (res2 == null) && all.size() == 2;
        assertThat(result, is(true));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name1", "desc1", 123L));
        tracker.add(new Item("name2", "desc2", 123L));
        tracker.add(new Item("name3", "desc3", 123L));
        int result = tracker.findAll().size();
        assertThat(result, is(3));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item[] expect = {new Item("name1", "desc1", 123L),
                new Item("name1", "desc2", 333L),
                new Item("name1", "desc234", 444L)
        };
        tracker.add(new Item("name1", "desc1", 123L));
        tracker.add(new Item("name1", "desc2", 333L));
        tracker.add(new Item("name1", "desc234", 444L));
        tracker.add(new Item("name2", "desc666", 666L));
        List<Item> result = tracker.findByName("name1");
        for (int i = 0; i < result.size(); i++) {
            expect[i].setId(result.get(i).getId());
        }
        assertThat(result, is(Arrays.asList(expect)));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item expect = new Item("name1", "desc1", 123L);
        Item item2 = new Item("name1", "desc1", 123L);
        Item item3 = new Item("name1", "desc1", 123L);
        tracker.add(expect);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(expect.getId());
        assertThat(result, is(expect));
    }
}
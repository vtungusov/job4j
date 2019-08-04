package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonsTest {

    @Test
    public void TrackerSingletonEnumTest() {

        TrackerSingleEnum instance1 = TrackerSingleEnum.INSTANCE;
        instance1.add(new Item("name1", "desc1"));

        TrackerSingleEnum instance2 = TrackerSingleEnum.INSTANCE;
        instance2.add(new Item("name2", "desc2"));

        Item[] except = instance2.findAll();

        assertThat(instance1.findAll(), is(except));
    }

    @Test
    public void TrackerSingletonTwoTest() {

        TrackerSingleTwo instance1 = TrackerSingleTwo.getInstance();
        instance1.add(new Item("name1", "desc1"));

        TrackerSingleTwo instance2 = TrackerSingleTwo.getInstance();
        instance2.add(new Item("name2", "desc2"));

        Item[] except = instance2.findAll();

        assertThat(instance1.findAll(), is(except));
    }

    @Test
    public void TrackerSingletonTwoThree() {

        TrackerSingleThree instance1 = TrackerSingleThree.getInstance();
        instance1.add(new Item("name1", "desc1"));

        TrackerSingleThree instance2 = TrackerSingleThree.getInstance();
        instance2.add(new Item("name2", "desc2"));

        Item[] except = instance2.findAll();

        assertThat(instance1.findAll(), is(except));
    }

    @Test
    public void TrackerSingletonTwoFour() {

        TrackerSingleFour instance1 = TrackerSingleFour.getInstance();
        instance1.add(new Item("name1", "desc1"));

        TrackerSingleFour instance2 = TrackerSingleFour.getInstance();
        instance2.add(new Item("name2", "desc2"));

        Item[] except = instance2.findAll();

        assertThat(instance1.findAll(), is(except));
    }
}
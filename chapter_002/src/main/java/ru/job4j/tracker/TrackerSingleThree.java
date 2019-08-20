package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleThree {
    private static final TrackerSingleThree OUR_INSTANCE = new TrackerSingleThree(); //зачем тут final? идея генерирует без него.

    private Tracker tracker = new Tracker();

    private TrackerSingleThree() {
    }

    public static TrackerSingleThree getInstance() {
        return OUR_INSTANCE;
    }

    /**
     * Adds Item to Tracker
     *
     * @param item add item
     * @return added item with preset ID
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * Replace Item in Tracker
     *
     * @param id   ID of replace item
     * @param item new Item
     * @return replacement success as boolean
     */
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * Delete Item from Tracker
     *
     * @param id id of delete item
     * @return replacement success as boolean
     */
    public boolean delete(String id) {
        return tracker.delete(id);
    }

    /**
     * Find all Item in Tracker
     *
     * @return array of found items
     */
    public List<Item> findAll() {
        return tracker.findAll();
    }

    /**
     * Find Item by name
     *
     * @param key item name
     * @return array of found items
     */
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    /**
     * Find Item by ID
     *
     * @param id item ID
     * @return found item
     */
    public Item findById(String id) {
        return tracker.findById(id);
    }

}

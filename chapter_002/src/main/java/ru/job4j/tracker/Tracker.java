package ru.job4j.tracker;

import java.util.Random;

/**
 * @author Vasily Tungusov
 * @version 1.0
 */

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private final Random RN = new Random();

    /**
     * Adds Item to Tracker
     *
     * @param item add item
     * @return added item with preset ID
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Generate ID for adds Item
     *
     * @return ID as String
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis()
                + this.RN.nextLong());
    }

    /**
     * Replace Item in Tracker
     *
     * @param id   ID of replace item
     * @param item new Item
     * @return replacement success as boolean
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
        boolean result = false;
        for (int i = 0; i < this.position; i++)
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        return result;
    }

    /**
     * Delete Item from Tracker
     *
     * @param id id of delete item
     * @return replacement success as boolean
     */
    public boolean delete(String id) {
        boolean result = false;

        for (int i = 0; i < this.position; i++)
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position);
                position--;
                result = true;
                break;
            }
        return result;
    }

    /**
     * Find all Item in Tracker
     *
     * @return array of found items
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.items, 0, result, 0, position);
        return result;
    }

    /**
     * Find Item by name
     *
     * @param key item name
     * @return array of found items
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int i = 0; i < this.position; i++)
            if (this.items[i].getName().equals(key))
                count++;
        Item[] result = new Item[count];
        for (int i = 0; i < this.position; i++)
            if (this.items[i].getName().equals(key))
                result[i] = this.items[i];
        return result;
    }

    /**
     * Find Item by ID
     *
     * @param id item ID
     * @return found item
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) { // position instead of length
            Item item = items[i];
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

}

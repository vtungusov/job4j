package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int insIndex = 0;
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            Task next = iterator.next();
            if (next.getPriority() > task.getPriority()) {
                insIndex = this.tasks.indexOf(next);
                break;
            }
            if (!iterator.hasNext()) {
                insIndex = this.tasks.indexOf(next) + 1;
                break;
            }
        }
        this.tasks.add(insIndex, task);
    }


    public Task take() {
        return this.tasks.poll();
    }
}
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
        var insIndex = 0;
        var index = -1;
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            var next = iterator.next();
            index++;
            if (next.getPriority() > task.getPriority()) {
                insIndex = index;
                break;
            }
            if (!iterator.hasNext()) {
                insIndex = index + 1;
                break;
            }
        }
        this.tasks.add(insIndex, task);
    }


    public Task take() {
        return this.tasks.poll();
    }
}
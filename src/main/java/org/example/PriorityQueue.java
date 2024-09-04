package org.example;

/**
 * Priority Queue Interface.
 * @author Josh Sherry
 */
public interface PriorityQueue {
    /**
     * Adds a new element into the queue.
     * @param house the object being added.
     */
    void add(House house);

    /**
     * Removes the Node at the front of the queue and returns the data.
     * @return If the list is empty this will return 'null'.
     */
    House poll();

    /**
     * Returns the element that is in the front of the queue.
     * @return If the list is empty this will return 'null'.
     */
    House peek();

    /**
     *
     * @return Returns the most expensive house in the queue.
     */
    House getMostExpensive();

    /**
     * Removes all elements from the list
     */
    void clear();

    /**
     *
     * @return Returns the amount of elements of the list.
     */
    int getLength();

    /**
     *
     * @return Returns true or false depending on whether the list is empty or not.
     */
    boolean isEmpty();
}

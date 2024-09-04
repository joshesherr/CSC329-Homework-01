package org.example;

/**
 * Linked List Implementation of a Priority Queue for Houses.
 * @author Josh Sherry
 */
public class PriorityQueueList implements PriorityQueue {

    /**
     * Default constructor.
     */
    PriorityQueueList(){
    }

    /**
     * Deep copy constructor.
     * @param list The list to create a deep copy from.
     */
    PriorityQueueList( PriorityQueueList list ) {
        PriorityQueueList listCopy = list.deepCopy();
        this.head = listCopy.head;
        this.length = listCopy.length;
    }

    //Private members
    /**
     * A node to hold house data, priority and which node is next in the queue.
     */
    private static class Node {
        House data;
        float priority;
        Node next = null;
    }
    /**
     * The head the rest of the list stems from.
     * Is null when list is empty.
     */
    private Node head = null;
    /**
     * Rather than calculating length every time the getLength method is called
     * this variable goes up when an element is added and down when an element is removed.
     */
    private int length = 0;

    /**
     * Creates a deep copy of all elements in the list and adds them to a new list.
     * @return A deep copy of this list.
     */
    public PriorityQueueList deepCopy() {
        PriorityQueueList list = new PriorityQueueList();
        //Return empty list if this list is empty
        if (isEmpty()) return list;

        //Set the head of the new list to a deep copy of the original head.
        Node searchNext = head;
        list.head = new Node();
        list.head.data = searchNext.data.deepCopy();
        Node newSearchNext = list.head;
        //loop through each element copying the values into the new list.
        while (searchNext.next != null) {

            newSearchNext.next = new Node();
            newSearchNext.next.data = searchNext.data.deepCopy();

            newSearchNext = newSearchNext.next;
            searchNext = searchNext.next;
        }
        //set the length to be the same and return
        list.length = length;
        return list;
    }

    //region implemented methods

    public House peek() {
        return (!isEmpty())? head.data : null;
    }

    public House poll() {
        if (!isEmpty()) {
            Node element = head;
            head = head.next;
            length--;
            return element.data;
        }
        return null;
    }

    public void add(House house) {
        Node temp = new Node();
        temp.data = house;
        temp.priority = house.getValue();
        if (isEmpty()) {
            head = temp;
        } else if (temp.priority > head.priority) {
            temp.next = head;
            head = temp;
        } else {
            Node searchNext;
            searchNext = head;
            while (searchNext.next != null && temp.priority <= searchNext.next.priority) {
                searchNext = searchNext.next;
            }

            temp.next = searchNext.next;
            searchNext.next = temp;
        }
        length++;
    }

    public House getMostExpensive() {
        return !this.isEmpty() ? head.data : null;
    }

    public void clear() {
        head = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return (head==null);
    }
    //endregion
}

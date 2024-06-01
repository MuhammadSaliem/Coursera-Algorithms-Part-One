package com.coursera.algorithms_course_one.week2.stack_and_queue.stack;

import java.util.Iterator;

/**
 * StackLinkedlist
 */
public class StackLinkedlist<Item> implements Iterable<Item> {

    private Node first;

    public StackLinkedlist()
    {
        
    }

    private class Node{
        Item item;
        Node next;
    }

    private class LinkedlistIterator implements Iterator<Item>
    {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public boolean isEmpty()
    {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedlistIterator();
    }
    


    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;        
    }

}
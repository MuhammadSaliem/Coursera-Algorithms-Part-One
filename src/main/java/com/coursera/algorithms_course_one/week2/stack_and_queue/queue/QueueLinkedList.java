package com.coursera.algorithms_course_one.week2.stack_and_queue.queue;

import java.util.Iterator;

/**
 * QueueLinkedList
 */
public class QueueLinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;

    private class Node{
        Item item;
        Node next;
    }

    private class LinkedListIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {
            return current != null;
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public void enqueue(Item item)
    {
        Node node = new Node();
        node.item = item;

        if(first == null && last == null)
        {
            first = last = node;
            return;
        }
        
        Node oldLast = last;
        last = new Node();
        last.item = item;
        oldLast.next = last;
    }

    public Item dequeue()
    {
        Node oldFirst = first;
        first = first.next;
        return oldFirst.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }    
}
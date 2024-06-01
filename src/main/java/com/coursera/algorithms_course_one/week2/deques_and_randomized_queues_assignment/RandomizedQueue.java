package com.coursera.algorithms_course_one.week2.deques_and_randomized_queues_assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;
    private int size;

    public RandomizedQueue() {
        arr = (Item[]) new Object[1];
    }

    private class ArrayIterator implements Iterator<Item> {
        private final Item[] copiedData;
        private int index;

        public ArrayIterator() {
            copiedData = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                copiedData[i] = arr[i];
            }
            StdRandom.shuffle(copiedData);
        }

        public boolean hasNext() {
            return index != copiedData.length;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!(hasNext()))
                throw new NoSuchElementException();

            index++;
            Item item = (Item) copiedData[index - 1];
            return item;
        }
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (size == arr.length)
            resize(size * 2);
        arr[size++] = item;
    }

    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException();

        int index = StdRandom.uniform(size);
        Item item = arr[index];

        if (index != size - 1) {
            arr[index] = arr[size - 1];
        }

        arr[size - 1] = null;
        size--;

        if (size != 0 && size == arr.length / 4)
            resize(arr.length / 2);

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException();

        int i = StdRandom.uniform(size);
        return (Item) this.arr[i];
    }

    private void resize(int size) {
        Item[] copyArr = (Item[]) new Object[size];

        for (int i = 0; i < this.size; i++) {
            copyArr[i] = (Item) arr[i];
        }

        arr = copyArr;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Ahmed");
        queue.enqueue("Khaled");
        queue.enqueue("Hassan");
        queue.enqueue("Reda");
        queue.enqueue("Mohamed");
        queue.enqueue("Amr");

        queue.displayQueue(queue);
        System.out.println(queue.sample());
        System.out.println(queue.sample());

        System.out.println(queue.dequeue());
        queue.displayQueue(queue);
        queue.displayQueue(queue);
        queue.displayQueue(queue);
    }

    private void displayQueue(RandomizedQueue queue) {
        Iterator<String> iter = queue.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " -> ");
        }
        System.out.println();
    }

}
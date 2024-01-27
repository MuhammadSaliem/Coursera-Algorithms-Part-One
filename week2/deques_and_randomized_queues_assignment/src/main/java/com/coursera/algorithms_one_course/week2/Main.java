package com.coursera.algorithms_one_course.week2.queue;


import java.util.Iterator;

import com.coursera.algorithms_one_course.week2.queue.QueueLinkedList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();

        
        deque.addLast("Ibrahim");
        displayQueue(deque);
        deque.addLast("Hussien");
        displayQueue(deque);
        deque.addLast("Khaled");
        displayQueue(deque);

        deque.addFirst("Ahmed");
        displayQueue(deque);
        deque.addFirst("Mohamed");
        displayQueue(deque);
        deque.addFirst("Hassan");
        displayQueue(deque);
        
        System.out.println(deque.removeFirst());
        displayQueue(deque);
        
        System.out.println(deque.removeLast());
        displayQueue(deque);


        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Ahmed");
        queue.enqueue("Mohmamed");
        queue.enqueue("Saleh");
        queue.enqueue("Hassan");
        queue.enqueue("Hassan");
        queue.enqueue("Hassan");
        queue.enqueue("Hassan");
        queue.enqueue("Hassan");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
    }

        public static void displayQueue(Deque deque)
    {
        Iterator<String> iter = deque.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " -> ");
        }
        System.out.println();
    }
}
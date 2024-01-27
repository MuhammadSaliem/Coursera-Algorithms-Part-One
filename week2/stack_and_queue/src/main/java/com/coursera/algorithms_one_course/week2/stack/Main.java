package com.coursera.algorithms_one_course.week2.stack;

import java.util.Iterator;

import com.coursera.algorithms_one_course.week2.queue.QueueLinkedList;

public class Main {
    public static void main(String[] args)
    {
        // StackArray<String> stack = new StackArray<>();
        StackLinkedlist<String> stack = new StackLinkedlist<>();

        stack.push("Ahmed");
        stack.push("Khaled");
        stack.push("Hassan");
        System.out.println("pop: " + stack.pop());
        stack.push("Ibrahim");
        stack.push("Moustaf");

        java.util.Iterator<String> iterator = stack.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("\n");

        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.enqueue("Ahmed");
        queue.enqueue("Khaled");
        queue.enqueue("Hassan");
        queue.enqueue("Ibrahim");
        queue.enqueue("Moustafa"); 
        
        displayQueue(queue);
        System.out.println("dequeue: " + queue.dequeue());
        displayQueue(queue);
        System.out.println("dequeue: " + queue.dequeue());
        displayQueue(queue);
        queue.enqueue("Malak");
        displayQueue(queue);

        java.util.Iterator<String> queueIterator = queue.iterator();
                
        while(queueIterator.hasNext())
        {
            System.out.println(queueIterator.next());
        }
        System.out.println();
    }

    public static void displayQueue(QueueLinkedList queue)
    {
        Iterator<String> iter = queue.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " -> ");
        }
    }
}

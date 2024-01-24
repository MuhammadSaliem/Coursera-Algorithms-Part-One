

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Object[] arr;
    private int size;

    public RandomizedQueue()
    {
        arr = (Item[]) new Object[1];
    }


    private class ArrayIterator implements Iterator<Item>
    {
        private int currentSize = size;
        private int count= 0;
        
        public boolean hasNext()
        {
            return count < currentSize;
        }
        

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }


        public Item next()
        {
            if(size == 0)
                throw new NoSuchElementException();

            Item item = (Item) arr[count++];
            return item;
        }
    }

    public void enqueue(Item item)
    {
        if(item == null)
            throw new IllegalArgumentException();

        if(size == arr.length)
            resize(size * 2);
        arr[size++] = item;
    }

    public Item dequeue()
    {
        if(size == 0)
            throw new NoSuchElementException();
        
        Item item = (Item) arr[--size];
        arr[size] = null;

        if(size != 0 && size == arr.length/4)
            resize(arr.length/2);

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }    

    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return size;
    }


    // return a random item (but do not remove it)
    public Item sample()
    {
        if(size == 0)
            throw new NoSuchElementException();
        
        int i = StdRandom.uniform(size);
        return (Item) this.arr[i];
    }

    private void resize(int size)
    {
        Item[] copyArr = (Item[]) new Object[size];

        for(int i = 0; i < this.size; i++)
        {
            copyArr[i] =(Item) arr[i];
        }
        
        arr = copyArr;
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("Ahmed");
        queue.enqueue("Khaled");
        queue.enqueue("Hassan");

        queue.displayQueue(queue);
        System.out.println(queue.sample());
        System.out.println(queue.sample());

        System.out.println(queue.dequeue());
        queue.displayQueue(queue);

    }

    private void displayQueue(RandomizedQueue queue)
    {
        Iterator<String> iter = queue.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " -> ");
        }
        System.out.println();
    }

}
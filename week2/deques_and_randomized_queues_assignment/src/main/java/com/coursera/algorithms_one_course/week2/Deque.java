
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node{
        Item item;
        Node next;
    }

    // construct an empty deque
    public Deque()
    {

    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return first == null;
    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if(item == null)
            throw new IllegalArgumentException();

        if(first == null && last == null)
        {
            first = last = new Node();
            first.item = item;
            size++;
            return;
        }

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        size++;
    }

    // add the item to the back
    public void addLast(Item item)
    {
        if(item == null)
            throw new IllegalArgumentException();

        if(first == null && last == null)
        {
            first = last = new Node();
            first.item = item;
            size++;
            return;
        }

        Node oldLast = last;
        last = new Node();
        last.item = item;
        oldLast.next = last;

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if(this.isEmpty())
            throw new NoSuchElementException();

        if(first == last)
        {
            Item item = first.item;
            first = last = null;
            size--;
            return item;
        }

        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if(this.isEmpty())
            throw new NoSuchElementException();

        Item item = last.item;

        if(first == last)
        {
            first = last = null;
            size--;
            return item;
        }

        Node current = first;

        while(current.next != last)
        {
            current = current.next;
        }

        current.next = null;
        last = current;
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>
    {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {

            if(current == null)
                throw new NoSuchElementException();

            Item item = current.item;
            current = current.next;
            
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported operation remove");
        }
        
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        Deque<Integer> deque = new Deque<>();
        deque.isEmpty();        
         deque.addLast(2);
        deque.removeFirst();
        deque.isEmpty();        
        deque.addLast(5);
        deque.removeFirst();
        System.err.println();
    }

}
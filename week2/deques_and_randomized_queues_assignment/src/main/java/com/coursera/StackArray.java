package com.coursera;

import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item> {

    private Item[] arr;
    private int size;

    public StackArray()
    {
        arr = (Item[]) new Object[1];
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int iter = size;

        @Override
        public boolean hasNext() {
            return iter > 0;
        }

        @Override
        public void remove()
        {
            
        }

        @Override
        public Item next() {
            return arr[--iter];
        }
        
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }


    public void push(Item item)
    {
        if(size == arr.length)
            resize(size * 2);
        arr[size++] = item;
        
    }

    public Item pop()
    {
        Item item = arr[--size];
        arr[size] = null;

        if(size > 0 && size == arr.length/4)
            resize(size/2);
        
        return item;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
         return new ReverseArrayIterator();
    }

    private void resize(int size)
    {
        Item[] copyArr = (Item[]) new Object[size];

        for(int i = 0; i < this.size; i++)
        {
            copyArr[i] = arr[i];
        }
        
        arr = copyArr;
    }

}

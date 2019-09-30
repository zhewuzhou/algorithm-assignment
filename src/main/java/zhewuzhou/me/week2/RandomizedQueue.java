package zhewuzhou.me.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INITIAL_SIZE = 2;

    private Item[] itemsArray;
    private int size;

    public RandomizedQueue() {
        itemsArray = (Item[]) new Object[INITIAL_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] newItemsArray = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newItemsArray[i] = itemsArray[i];
        }
        itemsArray = newItemsArray;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        autoEnlarge();
        itemsArray[size++] = item;
    }

    public Item dequeue() {
        validateEmpty();
        int index = randomIndex();
        Item item = itemsArray[index];
        itemsArray[index] = itemsArray[size - 1];
        itemsArray[size - 1] = null;
        size--;
        autoShrink();
        return item;
    }


    public Item sample() {
        validateEmpty();
        return itemsArray[randomIndex()];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] items;
        private int index;

        public RandomizedQueueIterator() {
            copyQueue();
            StdRandom.shuffle(items);
        }

        public boolean hasNext() {
            return index < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[index++];
        }

        private void copyQueue() {
            items = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                items[i] = itemsArray[i];
            }
        }
    }

    private void validateEmpty() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    private void autoShrink() {
        if (size > 0 && size == itemsArray.length / 4) resize(itemsArray.length / 2);
    }

    private int randomIndex() {
        return StdRandom.uniform(0, size);
    }

    private void autoEnlarge() {
        if (size == itemsArray.length) resize(2 * itemsArray.length);
    }
}

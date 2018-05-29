/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: MyArrayList
 */

import java.util.AbstractList;

public class MyArrayList extends AbstractList<Integer> {
    private static final int TEN = 10;
    private Integer[] array;
    private int capacity = TEN;
    private int size = 0;
    private void ensureCapacity (final int minCapacity) {
        if (size + minCapacity > capacity) {
            final Integer[] tempArr = new Integer[capacity * 2];
            capacity = capacity * 2;
            for (int i = 0; i < size; i++) {
                tempArr[i] = array[i];
            }
        array = tempArr;
        }
    }
    public MyArrayList() {
        array = new Integer[capacity];
    }
    public MyArrayList (final int initialCapacity) {
        array = new Integer[initialCapacity];
        capacity = initialCapacity;
    }
    public final boolean add (final Integer element) {
        ensureCapacity(1);
        array[size] = element;
        size++;
        return true;
    }
    public final void add (final int index, final Integer element) {
        ensureCapacity(1);
        size++;
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }
    public final Integer get (final int index) {
        checkRange(index);
        return array[index];
    }
    public final Integer set (final int index, final Integer element) {
        checkRange(index);
        final Integer replace = array[index];
        array[index] = element;
        return replace;
    }
    public final Integer remove (final int index) {
        checkRange(index);
        final Integer replace = array[index];
        for (int i = index; i <= size - 2; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        return replace;
    }
    public final boolean remove (final Integer element) {
        for (int i = 0; i != size; i++) {
            if (array[i] == element) {
                for (int j = i; j <= size - 2; j++) {
                    array[j] = array[j + 1];
                    }
                array[size - 1] = null;
                return true;
            }
        }
        return false;
    }
    public final int size () {
        return size;
    }
    public final void clear () {
        for (int i = 0; i != size; i++) {
            array[i] = null;
        }
    size = 0;
    }
    public final String toString () {
        final StringBuilder theString = new StringBuilder();
        theString.append("[");
        for (int i = 0; i != size; i++) {
            theString.append(array[i]);
            if (i == size - 1) {
                theString.append("]");
            } else {
                theString.append(", ");
            }
        }
        return theString.toString();
    }
    private void checkRange (final int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}


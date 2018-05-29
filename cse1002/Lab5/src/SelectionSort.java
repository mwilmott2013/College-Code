/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: SelectionSort
 */

import java.util.List;
import java.util.Collections;
import java.util.Random;

public class SelectionSort {
    private static final Random R = new Random(Long.getLong("seed",
            System.nanoTime()));
    public static void sort (final List<Integer> array) {
        int minimum = 0;
        for (int j = 0; j < array.size() - 1; j++) {
            minimum = j;
            for (int i = j + 1; i < array.size(); i++) {
                if (array.get(i) < array.get(minimum)) {
                    minimum = i;
                }
            }
            if (minimum != j) {
                final Integer a = array.set(j, array.get(minimum));
                array.set(minimum, a);
            }
        }
    }
    public static void main (final String[] args) {
        final int omega = Integer.parseInt(args[0]);
        final List<Integer> list = new MyArrayList(omega);
        for (int d = 1; d <= omega; d++) {
            list.add(d);
        }
        Collections.shuffle(list, R);
        System.out.println("Shuffled:");
        System.out.println(list.toString());
        sort(list);
        System.out.println("Sorted:");
        System.out.println(list.toString());
    }
}


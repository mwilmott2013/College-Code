/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: MyDeque
 */

import java.util.Scanner;
public class MyDeque<T> implements Deque<T> {
    private int firstpointer = -1;
    private T[] deque;
    private int lastpointer = deque.length;
    @SuppressWarnings("unchecked")
    public MyDeque (final int size) {
        deque = (T[]) new Object[size];
    }

    public final boolean isEmpty () {
        if (firstpointer == lastpointer && deque[firstpointer] == null) {
            return true;
        }
        return false;
    }

    public final void addFirst (final T item) throws BufferFullException {
        if (isEmpty()) {
            deque[firstpointer] = item;
            return;
        }

        final int backup = firstpointer;
        firstpointer = (firstpointer - 1) % deque.length;
        if (firstpointer < 0) {
            firstpointer += deque.length;
        }
        if (firstpointer == lastpointer) {
            firstpointer = backup;
            throw new BufferFullException();
        } else {
            deque[firstpointer] = item;
        }
    }

    public final T removeFirst () throws BufferEmptyException {
        if (firstpointer == lastpointer) {
            if (deque[firstpointer] == null) {
                throw new BufferEmptyException();
            } else {
                final T prey = deque[firstpointer];
                deque[firstpointer] = null;
                return prey;
            }
        }

        final T prey = deque[lastpointer];

        lastpointer = (lastpointer - 1) % deque.length;

        if (lastpointer > 0) {
            lastpointer += deque.length;
        }
        return prey;
    }

    public final void addLast (final T item) throws BufferFullException {
        if (isEmpty()) {
            deque[lastpointer] = item;
            return;
        }

        final int backup = lastpointer;
        lastpointer = (lastpointer + 1) % deque.length;
        if (lastpointer == firstpointer) {
            lastpointer = backup;
            throw new BufferFullException();
        } else {
            deque[lastpointer] = item;
        }
    }

    public final T removeLast () throws BufferEmptyException {
        if (lastpointer == firstpointer) {
            if (deque[lastpointer] == null) {
                throw new BufferEmptyException();
            } else {
                final T prey = deque[lastpointer];
                deque[lastpointer] = null;
                return prey;
            }
        }

        final T prey = deque[firstpointer];

        firstpointer = (firstpointer - 1) % deque.length;

        if (firstpointer > 0) {
            firstpointer += deque.length;
        }
        return prey;
    }


    public static void main (final String[] args) {
        final Stack<Integer> b = new MyStack<Integer>(Integer.parseInt(args[0]));
        final Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            final String command = sc.next();
            try {
                if (command.equalsIgnoreCase("addfirst")) {
                    final int item = sc.nextInt();
                    b.push (item);
                    System.out.println("addfirst " + item);
                }
                if (command.equalsIgnoreCase("addlast")) {
                    final int item = sc.nextInt();
                    b.push (item);
                    System.out.println("addlast " + item);
                }
                if (command.equalsIgnoreCase("removefirst")) {
                    final int item = b.pop ();
                    System.out.println("removefirst " + item);
                }
                if (command.equalsIgnoreCase("removelast")) {
                    final int item = b.pop ();
                    System.out.println("removelast " + item);
                }
            } catch (final BufferEmptyException ex) {
                System.out.println("Deque is empty");

            } catch (final BufferFullException ex) {
                System.out.println("Deque is full");
            }
    }
        sc.close();
    }
}




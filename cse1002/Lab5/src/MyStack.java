/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: MyStack
 */

import java.util.Scanner;
public class MyStack<T> implements Stack<T> {
    private int pointer = -1;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public MyStack (final int size) {
        stack = (T[]) new Object[size];
    }

    public final boolean isEmpty () {
        if (pointer == 0) {
            return true;
        }
        return false;
    }

    public final void push (final T item) throws BufferFullException {
        pointer++;
        if (pointer >= stack.length) {
            throw new BufferFullException();
        } else {
            stack[pointer] = item;
        }
    }

    public final T pop () throws BufferEmptyException {
        if (pointer < 0) {
            throw new BufferEmptyException();
        }
        pointer--;
        return stack[pointer + 1];
    }

    public static void main (final String[] args) {
        final Stack<Integer> b = new MyStack<Integer>(Integer.parseInt(args[0]));
        final Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            final String command = sc.next();
            try {
                if (command.equalsIgnoreCase("push")) {
                    final int item = sc.nextInt();
                    b.push (item);
                    System.out.println("push " + item);
                }
                if (command.equalsIgnoreCase("pop")) {
                    final int item = b.pop ();
                    System.out.println("pop " + item);
                }
            } catch (final BufferEmptyException ex) {
                System.out.println("Stack is empty");

            } catch (final BufferFullException ex) {
                System.out.println("Stack is full");
            }
    }
    }
}



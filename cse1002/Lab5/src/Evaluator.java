/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: Evaluator
 */

import java.util.ArrayDeque;
import java.util.Scanner;
public final class Evaluator {
    private static ArrayDeque<Double> numbers;
    private static ArrayDeque<String> operations;
    public static void main (final String[] args) {
        numbers = new ArrayDeque<Double>();
        operations = new ArrayDeque<String>();
        final Scanner sc = new Scanner (System.in);
        while (sc.hasNextLine()) {
            final String a = sc.nextLine();
            final String[] big = a.split(" ");
            for (int i = 0; i < big.length; i++) {
            whatever(big[i]);
            }
            final double finalResult = numbers.removeLast();
            System.out.printf("%.2f%n", finalResult);
        }

        sc.close();
    }
    private static void whatever (final String next) {
        if (next.equals("(")) {
            return;
        } else if (next.equals("+") || next.equals("-") || next.equals("*")
                || next.equals("/") || next.equals("^") || next.equals("sqrt")
                || next.equals("abs")) {
            operations.addLast(next);
        } else if (next.equals(")")) {
            final double result = solver();
            numbers.addLast(result);
        } else {
            numbers.addLast(Double.parseDouble(next));
        }
    }
    private static double solver () {
        final String c = operations.removeLast();
        double d = 0.0;
        if (c.equals("+")) {
            final double a = numbers.removeLast();
            final double b = numbers.removeLast();
            d = a + b;
        } else if (c.equals("-")) {
            final double a = numbers.removeLast();
            final double b = numbers.removeLast();
            d = b - a;
        } else if (c.equals("*")) {
            final double a = numbers.removeLast();
            final double b = numbers.removeLast();
            d = a * b;
        } else if (c.equals("/")) {
            final double a = numbers.removeLast();
            final double b = numbers.removeLast();
            d = b / a;
        } else if (c.equals("^")) {
            final double a = numbers.removeLast();
            final double b = numbers.removeLast();
            d = Math.pow(b, a);
        } else if (c.equals("sqrt")) {
            final double a = numbers.removeLast();
            d = Math.sqrt(a);
        } else if (c.equals("abs")) {
            final double a = numbers.removeLast();
            d = Math.abs(a);
        }
        return d;
    }
}




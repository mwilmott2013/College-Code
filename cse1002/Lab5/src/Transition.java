/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Fall 2012
 * Project: web
 */

import java.util.Scanner;

public class Transition {


    public static void main (final String[] args) {

        final Scanner stdIn = new Scanner (System.in);
        final double leap1 = Double.parseDouble(args[0]);
        final double leap2 = 1 - leap1;
        final int n = stdIn.nextInt (); // number of pages
        final int[][] counts = new int[n][n]; // counts[i][j] = # links from page i to
                                        // page j
        final int[] outDegree = new int[n]; // outDegree[j] = # links from page i to
                                      // anywhere

        // Accumulate link counts.
        while (stdIn.hasNextInt ()) {
            final int i = stdIn.nextInt ();
            final int j = stdIn.nextInt ();
            outDegree[i]++;
            counts[i][j]++;
        }

        System.out.println (n + " " + n);

        // Print probability distribution for row i.
        for (int i = 0; i < n; i++) {

            // Print probability for column j.
            for (int j = 0; j < n; j++) {
                double p = 0.0;
                if (outDegree[i] != 0) {
                    p = leap1 * counts[i][j] / outDegree[i] + leap2 / n;
                }
                System.out.printf ("%7.5f ", p);
            }
            System.out.println ();
        }
    }
}

/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Fall 2012
 * Project: table
 */

class Table {

   private static final int HUNDRED = 100;

public static void main (final String[] args) {
      final int start = Integer.parseInt(args[0]);
      int i;
      for (i = 1; i <= start; i++) {
         System.out.printf("%-,7d", i);
         System.out.printf(" 0X%04x", i);
         System.out.printf("%,9d", i * i);
         System.out.printf("%,9d", i * i * i);
         System.out.printf("%9.3f", Math.log(i * i) / Math.log(2));
         System.out.printf("%7d%%", Math.round(((float) i / (float) start) * HUNDRED));
         System.out.println();
      }
   }
}


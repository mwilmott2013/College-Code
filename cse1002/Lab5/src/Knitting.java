import java.util.Scanner;

/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: knitting
 */

public final class Knitting {

public static void main (final String[] args) {
   final Scanner input = new Scanner(System.in, "US-ASCII");
   while (input.hasNextInt()) {
      final int firstRowStitches = input.nextInt(); //N
      final int numberOfRows = input.nextInt(); //M
      final int repeatingLength = input.nextInt(); //K
      final int[] stitchArray = new int[repeatingLength]; //The pattern parameters
      if (firstRowStitches == 0 && numberOfRows == 0 && repeatingLength == 0) {
         break; //Ends the Program
      }
   for (int i = 0; i < repeatingLength; i++) {
      stitchArray[i] = input.nextInt(); //Enters Pattern Parameters
   }
   int totalStitches = 0;
   int currentRow = firstRowStitches; //Establishes the first row as the current row
   for (int j = 0; j < numberOfRows; j++) {
      totalStitches += currentRow; //Adds stitches to total
      currentRow += stitchArray[j % repeatingLength]; //Moves on to the next row
   }
   System.out.printf("%d%n", totalStitches); //Prints the total number of stitches
   }
}
}


import java.util.Scanner;

/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: students
 */

class Students {

private static final double DEVIAD = -2.0;
private static final double DEVIAC = -1.0;
private static final double DEVIAB = 0.0;
private static final double DEVIAA = 1.0;
public static void main (final String[] args) {
      final Scanner scanner = new Scanner(System.in);
      final int i = scanner.nextInt();
      final String[] students = new String[i];
      final int[] scores = new int[i];
      int j;
      int m;
      int totalscore = 0;
      for (j = 0; j != i; j++) {
         students[j] = scanner.next() + " " + scanner.next();
         scores[j] = scanner.nextInt();
         totalscore += scores[j];
      }
      final double classaverage = (double) totalscore / i;
      final double devia = devia(classaverage, scores, i);
      System.out.printf("%-16s%8s        %6s%n", "Name", "Grade", "Letter");
      for (m = 0; m != i; m++) {
         final double fixedscore = (scores[m] - classaverage) / devia;
         final char lettergrade = lgcalc(fixedscore);
         System.out.printf("%-16s%8s        %6s%n", students[m], scores[m], lettergrade);
      }
      System.out.printf("%-16s%8.2f", "Average", classaverage);
      scanner.close();
   }

public static double devia (final double classaverage, final int[] scores, final int i) {
   double sectotal = 0.0;
   int k;
   for (k = 0; k != i; k++) {
      sectotal += (classaverage - scores[k]) * (classaverage - scores[k]);
   }
   return Math.sqrt(sectotal / i);
}
public static char lgcalc (final double fixedscore) {
   if (fixedscore > DEVIAA) {
      return 'A';
   } else if (fixedscore > DEVIAB) {
      return 'B';
   } else if (fixedscore > DEVIAC) {
      return 'C';
   } else if (fixedscore > DEVIAD) {
      return 'D';
   } else {
      return 'F';
   }
}
}


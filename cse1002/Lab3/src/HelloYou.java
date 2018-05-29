/*

 */

import java.util.Random;

class HelloYou {
   private static final int SEVEN = 7;
   private String h = "HELLO";
   private static final Random RNG = new Random(Long.getLong("seed", System.nanoTime()));

   public static void main (final String[] args) {
      int j;
      for (j = 0; j < SEVEN; j++) {
         System.out.println("This is my class!");
         System.out.println(String.valueOf(RNG.nextDouble()));
         System.out.println(args[0]);
      }
   }

   public void setThis () {
      System.out.println("That!");
   }
}


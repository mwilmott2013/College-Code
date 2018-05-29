/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: RandomPoem
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomPoem {
    private static final int FOUR = 4;
    private static final int THREE = 3;
    private static Random rng = new Random
            (Long.getLong("seed", System.nanoTime()));
    private static ArrayList<String> slist1 = new ArrayList<String>();
    private static ArrayList<String> slist2 = new ArrayList<String>();
    private static ArrayList<String> rest = new ArrayList<String>();
    public static void main (final String[] args) {
        final Scanner h = new Scanner(System.in);
        final int wordCount = Integer.parseInt(args[0]);
        final int verseCount = Integer.parseInt(args[1]);
        final String suffixA = args[2];
        final String suffixB = args[THREE];
        final String rhymeScheme = args[FOUR];
        final int lineCount = rhymeScheme.length();
        final StringBuilder poembuild = new StringBuilder();

        while (h.hasNext()) {
            final String newWord = h.next();
            if (newWord.endsWith(suffixA)) {
                slist1.add(newWord);
            } else if (newWord.endsWith(suffixB)) {
                slist2.add(newWord);
            } else {
                rest.add(newWord);
            }
        }


        for (int i = 0; i < verseCount; i++) {
            for (int j = 0; j < lineCount; j++) {
                poembuild.append(capitalize
                        (rest.get(rng.nextInt(rest.size()))));
                    poembuild.append(" ");
                for (int k = 0; k < wordCount - 2; k++) {
                    poembuild.append(rest.get(rng.nextInt(rest.size())));
                    poembuild.append(" ");
                }
                if (rhymeScheme.charAt(j) == 'A') {
                    poembuild.append(slist1.get(rng.nextInt(slist1.size())));
                } else {
                    poembuild.append(slist2.get(rng.nextInt(slist2.size())));
                }
                poembuild.append("%n");

            }
            poembuild.append("%n%n");
        }
        System.out.printf(poembuild.toString());
        h.close();
    }

    private static String capitalize (final String entry) {
        final char letter = Character.toUpperCase(entry.charAt(0));
        return letter + entry.substring(1);
    }

}

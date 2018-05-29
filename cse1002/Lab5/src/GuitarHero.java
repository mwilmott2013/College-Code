/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: GuitarHero
 */

import java.util.ArrayList;
import java.util.Scanner;
public class GuitarHero {
    private static final int FOWERFOWERONEOHOH = 44100;
    private static final double TWELVEPOINTOH = 12.0;

    public static void main (final String[] args) {
    final Scanner sc = new Scanner(System.in);
    final ArrayList<Double> theSong = new ArrayList<Double>();
    while (sc.hasNext()) {
        final int note = sc.nextInt();
        final float time = sc.nextFloat();
        final GuitarString guitar = new GuitarString
                (440 * Math.pow(2, note / TWELVEPOINTOH));
        guitar.pluck();

        for (int i = 0; i < time * FOWERFOWERONEOHOH; i++) {
            theSong.add(guitar.sample());
            guitar.tic();
        }
    }
    final double[] output = new double[theSong.size()];

    for (int j = 0; j < theSong.size(); j++) {
        output[j] = theSong.get(j);
    }
    StdAudio.play(output);
    sc.close();
}
}



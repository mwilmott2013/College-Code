/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: GuitarString
 */

import java.util.ArrayList;
import java.util.Random;
public final class GuitarString {
    private static final double THREE = .996;
    private static final double TWO = .5;
    private static final double ONE = 44100.0;
    private double frequency;
    private ArrayDeque<Double> samplesong;
    private int n;
    private static Random rng = new Random
            (Long.getLong("seed", System.nanoTime()));
    public GuitarString (final double freq) {
        this.frequency = freq;
        n = (int) Math.round(ONE / freq);
        samplesong = new ArrayDeque<Double>(n);
    }
    public void pluck () {
        samplesong.clear();
        for (int i = 0; i < n; i++) {
            samplesong.addLast(rng.nextDouble() - TWO);
        }
    }
    public void tic () {
        final double itemOne = samplesong.removeFirst();
        final double itemTwo = samplesong.getFirst();
        samplesong.addLast(((itemOne + itemTwo) / 2) * THREE);

    }
    public double sample () {
        return samplesong.getFirst();
    }
}




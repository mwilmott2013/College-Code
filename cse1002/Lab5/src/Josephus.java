/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: Josephus
 */

import java.util.List;
import java.util.ListIterator;

public class Josephus {
    private static final int TRIALS = 10;
    public static void main (final String[] args) throws ClassNotFoundException,
    InstantiationException, IllegalAccessException {
        final int listSize = Integer.parseInt(args[0]);
        final int stepSize = Integer.parseInt(args[1]);
        final Class<?> clazz = Class.forName(args[2]);
        int lastSoldier = 0;
        final StopWatch clock = new StopWatch(true);
        for (int i = 0; i < TRIALS; i++) {
            final java.util.List<Integer> list =
            		(java.util.List<Integer>) clazz.newInstance();
            for (int j = 1; j <= listSize; j++) {
                list.add(j);
            }
            clock.start();
            lastSoldier = suicide(list, stepSize);
            clock.stop();
        }
        final double averageTime = clock.getAverageTime();
        System.out.println("Last Soldier: " + lastSoldier);
        System.out.println("Average Running Time: " + averageTime);
    }


    public static int suicide (final List<Integer> list, final int k) {
        int i = 0;
        ListIterator<Integer> tango = list.listIterator();
        while (list.size() > 1) {

            tango.next();
            i++;
            if ((i) % k == 0) {
                tango.remove();
            }
            if (!tango.hasNext()) {
                tango = list.listIterator();
            }
        }
        return list.get(0);
    }
}


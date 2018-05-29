/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: ManateeRescue
 */

import java.util.Scanner;
import java.util.ArrayList;

public final class ManateeRescue {
    private static ArrayList<Integer> obsSize;
    private static ArrayList<Integer> obsPos;
    public static void main (final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        obsSize = new ArrayList<Integer>();
        obsPos = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            final int sj = Integer.parseInt(sc.next());
            final int pj = Integer.parseInt(sc.next());
            obsSize.add(sj);
            obsPos.add(pj);
        }
        final boolean result = escape(m);
        if (result) {
            System.out.println("Hugh Manatee is saved!");
        } else {
            System.out.println("Hugh Manatee is doomed!");
        }
        sc.close();
    }
    private static boolean escape (final int m) {
        int indexA = -1;
        int indexB = -1;
        for (int j = 0; j < obsPos.size(); j++) {
            if (obsPos.get(j) < m) {
                if (indexA == -1) {
                    indexA = j;
                } else if (obsPos.get(j) > obsPos.get(indexA)) {
                    indexA = j;
                }
            } else {
                if (indexB == -1) {
                    indexB = j;
                } else if (obsPos.get(j) < obsPos.get(indexB)) {
                    indexB = j;
                }
            }
        }
        if (indexA == -1 || indexB == -1) {
            return true;
        } else {
            final int distance = obsPos.get(indexB) - obsPos.get(indexA);
            if (distance > obsSize.get(indexA)) {
                obsSize.remove(indexA);
                obsPos.remove(indexA);
                return escape(m);
            } else if (distance > obsSize.get(indexB)) {
                obsSize.remove(indexB);
                obsPos.remove(indexB);
                return escape(m);
            }
        }
        return false;
    }
}


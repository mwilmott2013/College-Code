/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Fall 2012
 * Project: recursivesquares
 */

public class RecursiveSquares {

    private static final int THREE = 3;
    private static final int FOWER = 4;
    private static final double SQUARER = 2.2;
    private static final double SQUARERTIMESTWO = 4.4;
    private static final double SQUAREHEIGHT = 150.0;
    private static final double SQUAREWIDTH = 150.0;

    public static void main (final String[] args) {

        final int t = Integer.parseInt(args[0]);
        StdDraw.setXscale(0.0, SQUAREWIDTH);
        StdDraw.setYscale(0.0, SQUAREHEIGHT);
        square(t, FOWER, SQUAREWIDTH / 2,
                SQUAREHEIGHT / 2, SQUAREWIDTH / SQUARERTIMESTWO);
        }

    private static void square (final int t, final int counter,
            final double x, final double y, final double r) {
        if (counter == 0) {
            return;
        }

        switch (t) {
        case 1:
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(x, y, r);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.square(x, y, r);
            square(t, counter - 1, x - r, y - r, r / SQUARER);
            square(t, counter - 1, x - r, y + r, r / SQUARER);
            square(t, counter - 1, x + r, y + r, r / SQUARER);
            square(t, counter - 1, x + r, y - r, r / SQUARER);
            break;
        case 2:
            square(t, counter - 1, x - r, y + r, r / SQUARER);
            square(t, counter - 1, x + r, y + r, r / SQUARER);
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(x, y, r);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.square(x, y, r);
            square(t, counter - 1, x - r, y - r, r / SQUARER);
            square(t, counter - 1, x + r, y - r, r / SQUARER);
            break;
        case THREE:
            square(t, counter - 1, x - r, y - r, r / SQUARER);
            square(t, counter - 1, x + r, y - r, r / SQUARER);
            square(t, counter - 1, x - r, y + r, r / SQUARER);
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(x, y, r);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.square(x, y, r);
            square(t, counter - 1, x + r, y + r, r / SQUARER);
            break;
        default:
            break;
        }
    }
}

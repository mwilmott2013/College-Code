/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Fall 2012
 * Project: randomwalk
 */
import java.util.Random;

public class RandomWalk {

    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final double POINTOHONE = 0.01;
    private static final double POINTOHOHTWO = 0.002;
    private static final Random R = new Random(Long.getLong("seed",
            System.nanoTime()));

    public static void main (final String[] args) {

        final double n = Double.parseDouble(args[0]);
        int t = Integer.parseInt(args[1]);
        StdDraw.setXscale(0.0, n);
        StdDraw.setYscale(0.0, n);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(POINTOHOHTWO);
        for (int i = 0; i <= n - 1; i++) {
            StdDraw.line(0, i, n, i);
            StdDraw.line(i, 0, i, n);
        }
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(POINTOHONE);
        int dogx = (int) n / 2;
        int dogy = (int) n / 2;
        int newdogX;
        int newdogY;
        final boolean[][] f = new boolean[(int) n + 1][(int) n + 1];
        while (dogx > 0 && dogx < n && dogy > 0 && dogy < n && t > 0) {
            if (dogx == 0 && f[dogx][dogy + 1] && f[dogx][dogy - 1]
                    && f[dogx + 1][dogy]) {
                t--;
                break;
            } else if (dogx == ((int) n - 1) && f[dogx][dogy + 1]
                    && f[dogx][dogy - 1] && f[dogx - 1][dogy]) {
                t--;
                break;
            } else if (dogy == 0 && f[dogx][dogy + 1] && f[dogx + 1][dogy]
                    && f[dogx - 1][dogy]) {
                t--;
                break;
            } else if (dogy == ((int) n - 1) && f[dogx][dogy - 1]
                    && f[dogx + 1][dogy] && f[dogx - 1][dogy]) {
                t--;
                break;
            } else if (f[dogx + 1][dogy] && f[dogx][dogy + 1]
                    && f[dogx - 1][dogy] && f[dogx][dogy - 1]) {
                t--;
                break;
            }
            final int movement = R.nextInt(FOUR);
            if (movement == 0 && !f[dogx][dogy + 1]) {
                newdogX = dogx;
                newdogY = dogy + 1;
                StdDraw.line(dogx, dogy, newdogX, newdogY);
                dogx = newdogX;
                dogy = newdogY;
                if (newdogX >= 0 && newdogX <= (int) n - 1 && newdogY >= 0
                        || newdogY <= (int) n - 1) {
                    f[newdogX][newdogY] = true;
                }
            } else if (movement == 1 && !f[dogx + 1][dogy]) {
                newdogX = dogx + 1;
                newdogY = dogy;
                StdDraw.line(dogx, dogy, newdogX, newdogY);
                dogx = newdogX;
                dogy = newdogY;
                if (newdogX >= 0 && newdogX <= (int) n - 1 && newdogY >= 0
                        || newdogY <= (int) n - 1) {
                    f[newdogX][newdogY] = true;
                }
            } else if (movement == 2 && !f[dogx][dogy - 1]) {
                newdogX = dogx;
                newdogY = dogy - 1;
                StdDraw.line(dogx, dogy, newdogX, newdogY);
                dogx = newdogX;
                dogy = newdogY;
                if (newdogX >= 0 && newdogX <= (int) n - 1 && newdogY >= 0
                        || newdogY <= (int) n - 1) {
                    f[newdogX][newdogY] = true;
                }
            } else if (movement == THREE && !f[dogx - 1][dogy]) {
                newdogX = dogx - 1;
                newdogY = dogy;
                StdDraw.line(dogx, dogy, newdogX, newdogY);
                dogx = newdogX;
                dogy = newdogY;
                if (newdogX >= 0 && newdogX <= (int) n - 1 && newdogY >= 0
                        || newdogY <= (int) n - 1) {
                    f[newdogX][newdogY] = true;
                }
            }
        }
    }
}

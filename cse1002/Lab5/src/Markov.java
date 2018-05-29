import java.util.Scanner;

public class Markov {

    public static void main (final String[] args) {

        Scanner stdIn = new Scanner (System.in);

        int trials = Integer.parseInt (args[0]); // number of iterations
        int n = stdIn.nextInt (); // number of pages
        stdIn.nextInt (); // ignore integer required by input format

        // Read p[][] from StdIn.
        double[][] p = new double[n][n]; // p[i][j] = prob. surfer moves from
                                         // page i to page j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = stdIn.nextDouble ();
            }
        }

        // Use the power method to compute page ranks.
        double[] rank = new double[n];
        rank[0] = 1.0;
        for (int t = 0; t < trials; t++) {

            // Compute effect of next move on page ranks.
            double[] newRank = new double[n];
            for (int j = 0; j < n; j++) {
                // New rank of page j is dot product of old ranks and column j
                // of p[][].
                for (int k = 0; k < n; k++) {
                    newRank[j] += rank[k] * p[k][j];
                }
            }

            // Update page ranks.
            rank = newRank;
        }

        // print page ranks
        for (int i = 0; i < n; i++) {
            System.out.printf ("%d : %8.5f\n", i, rank[i]);
        }
        System.out.println ();
    }
}

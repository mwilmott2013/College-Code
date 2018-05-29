public class Gaussian {

    private static final double EIGHTDOUBLE = 8.0;
    private static final int THREE = 3;
    private static final double POINTFIVE = 0.5;
    private static final int EIGHT = 8;
    private static final double DECIMAL = .00000001;
    private static final int NEGATIVEEIGHTINT = -8;
    private static final double NEGATIVEEIGHTDOUBLE = -8.0;



    // return phi(x) = standard Gaussian pdf
    public static double phi (double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    // return phi(x, mu, signma) = Gaussian pdf with mean mu and stddev sigma
    public static double phi (double x, double mu, double sigma) {
        return phi((x - mu) / sigma) / sigma;
    }

    // return Phi(z) = standard Gaussian cdf using Taylor approximation
    public static double phi (double z) {
        if (z < NEGATIVEEIGHTDOUBLE) {
        return 0.0;
        }
        if (z >  EIGHTDOUBLE) {
        return 1.0;
        }
        double sum = 0.0, term = z;
        for (int i = THREE; sum + term != sum; i += 2) {
            sum  = sum + term;
            term = term * z * z / i;
        }
        return POINTFIVE + sum * phi(z);
    }

    // return Phi(z, mu, sigma) = Gaussian cdf with mean mu and stddev sigma
    public static double phi (double z, double mu, double sigma) {
        return phi((z - mu) / sigma);
    }

    // Compute z such that Phi(z) = y via bisection search
    public static double phiInverse (double y) {
        return phiInverse(y, DECIMAL, NEGATIVEEIGHTINT, EIGHT);
    }

    // bisection search
    private static double phiInverse (double y, double delta, double lo, double hi) {
        final double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) {
            return mid;
        } else if (phi(mid) > y) {
            return phiInverse(y, delta, lo, mid);
        } else {
            return phiInverse(y, delta, mid, hi);
        }
    }



    // test client
    public static void main (String[] args) {
        double z     = Double.parseDouble(args[0]);
        double mu    = Double.parseDouble(args[1]);
        double sigma = Double.parseDouble(args[2]);
        System.out.println(Phi(z, mu, sigma));
        double y = Phi(z);
        System.out.println(PhiInverse(y));
    }

}


class Lab6b {
	public static void main(String args[]) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		double d = Double.parseDouble(args[3]);
		double x = Double.parseDouble(args[4]);
		double y = Double.parseDouble(args[5]);
		double e = Math.pow((a + b), 2);
		double f = (a * a) + (2 * a * b) + (b * b);
		double g = (a + b) * (c + d);
		double h = (a * c) + (a * d) + (b * c) + (b * d);
		double j = Math.pow(x, a) * Math.pow(x, b);
		double k = Math.pow(x, (a + b));
		double l = Math.pow(x, a) * Math.pow(y, a);
		double m = Math.pow((x * y), a);
		System.out.println("Formula 1: " + e);
		System.out.println("Formula 2: " + f);
		System.out.println("Formula 3: " + g);
		System.out.println("Formula 4: " + h);
		System.out.println("Formula 5: " + j);
		System.out.println("Formula 6: " + k);
		System.out.println("Formula 7: " + l);
		System.out.println("Formula 8: " + m);
		}
	}
// When using 2.0 for all values, all formulas are the same.
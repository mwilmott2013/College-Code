class Lab6c {
	public static void main(String args[]) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double x = (2 * a * b) / (a + b);
		double formula = ((x + a) / (x - a)) + ((x + b) / (x - b));
		System.out.println("Answer: " + formula);
		}
	}
// Used 1.0 and 2.0 first time, used 2.0 and 4.0 second time.  Both times had same output: 2.000000000000000018.
// At same value, infinity.
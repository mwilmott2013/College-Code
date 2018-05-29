class Lab6d {
	public static void main(String args[]) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		double formula = (1 / (1 + (c / (a + b)))) + (1 / (1 + (a / (b + c)))) + (1 / (1 + (b / (c + a))));
		System.out.println("Answer: " + formula);
		}
	}
// Used 1.0, 2.0, 3.0 first time, used 3.0, 2.0, and 5.0 second time.  Both times had same output: 2.0.
// At 0.0, NaN.
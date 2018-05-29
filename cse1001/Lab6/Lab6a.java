class Lab6a {
	public static void main(String args[]) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Math.pow(a, 3);
		double d = Math.pow(b, 3);
		double e = Math.pow(a, 2);
		double f = Math.pow(b, 2);
		double g = a * b;
		double h = (c + d) / (e - g + f);
		double i = (c - d) / (e + g + f);
		System.out.println("The result of the first formula is: " + h);
		System.out.println("The result of the second formula is: " + i);
		}
	}
// I got 4.0 for the first formula, and 0.0 for the second formula.
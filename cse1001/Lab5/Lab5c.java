class Lab5c {
	public static void main(String args[]) {
		double F = Double.parseDouble(args[0]);
		double c = (F - 32.0) * 5.0 / 9.0;
		System.out.println("Conversion: " + c + " celsius.");
	}
}
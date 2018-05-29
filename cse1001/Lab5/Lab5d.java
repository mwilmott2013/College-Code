class Lab5d {
	public static void main(String args[]) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);
		int e = Integer.parseInt(args[4]);
		System.out.println("The five numbers are: " + a + b + c + d + e);
		int f = a+b+c+d+e;
		System.out.println("The sum of these five numbers is:" + f);
		int g = args.length;
		System.out.println("Also, there were " + g + " command line arguments.");
	}
}
class Lab9c {
	public static void main(String args[]) {
		int x = Integer.parseInt(args[0]);
		int a = x / 1000;
		int b = (x / 100) % 10;
		int c = ((x / 10) % 100) % 10;
		int d = ((x % 1000) % 100) % 10;
		System.out.println("The first and last digits are: " + a + " , " + d);
		if (a >= d) {
			System.out.println("The first is bigger than the last.");
			}
		else {
			System.out.println("The last is bigger than the first.");
			}
		int e = (a + b) + (c + d);
		System.out.println("The sum of all the numbers is: " + e);
		}
	}